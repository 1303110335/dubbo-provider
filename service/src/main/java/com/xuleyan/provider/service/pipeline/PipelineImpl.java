/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

import com.google.common.base.Preconditions;
import com.xuleyan.provider.service.utils.OrderUtil;
import com.xuleyan.provider.service.valve.Valve;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.Strings;

/**
 *
 * @author xuleyan
 * @version PipelineImpl.java, v 0.1 2021-08-21 8:44 下午
 */
@Slf4j
public class PipelineImpl implements Pipeline {

    private static final String DefaultLabel = PipelineImpl.class.getName();
    private String  label;

    /**
     * 阀门列表
     */
    private static Valve[] valves;

    public static Valve[] getValves() {
        return valves;
    }

    public static void setValves(Valve[] valves) {
        PipelineImpl.valves = valves;
    }

    public static void setValves(Valve[] valves, boolean isOrder) {
        if (isOrder) {
            OrderUtil.shuffleOrder(valves);
        }
        PipelineImpl.valves = valves;
    }

    @Override
    public String getLabel() {
        return Strings.isNullOrEmpty(label) ? DefaultLabel : label;
    }

    @Override
    public PipelineInvocationHandle newInvocation() {
        return new PipelineContextImpl(null);
    }

    @Override
    public PipelineInvocationHandle newInvocation(PipelineContext parentContext) {
        return new PipelineContextImpl(parentContext);
    }

    @Override
    public void close() throws Exception {
        if (valves != null && valves.length > 0) {
            try {
                for (Valve valve : valves) {
                    valve.close();
                }
            } catch (Exception ex) {
                log.error("close valve", ex);
            }
        }
    }

    /**
     * 实现<code>PipelineContext</code>
     */
    private final class PipelineContextImpl implements PipelineContext, PipelineInvocationHandle {

        private final PipelineContext parentContext;

        private String traceId;
        protected int executingIndex = -1;
        protected int executedIndex = -1;

        private PipelineContextImpl(PipelineContext parentContext) {
            this.parentContext = parentContext;
        }

        @Override
        public void invokeNext() {
            if (isBroken()) {
                return;
            }

            try {
                executingIndex++;
                executedIndex++;
                if (executingIndex < valves.length) {
                    Valve executingValve = valves[executingIndex];
                    PipelineUtils.invokeValve(executingValve, this, traceId);

                    // 自动调用下一个valve
                    invokeNext();
                }
            } finally {
                executingIndex--;
            }
        }

        @Override
        public void clearAttribute(String key) {

        }

        @Override
        public void invoke() {
            Preconditions.checkState(!isBroken(), "cannot reInvoke a broken pipeline");
            executingIndex = executedIndex = -1;
            invokeNext();
        }

        @Override
        public String traceId(String traceId) {
            return null;
        }

        @Override
        public boolean isBroken() {
            return false;
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void doBreak() {

        }

        @Override
        public void doBreak(boolean breakParent) {

        }

        @Override
        public Object getAttribute(String key) {
            return null;
        }

        @Override
        public void setAttribute(String key, Object value, boolean parent) {

        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }
    }
}
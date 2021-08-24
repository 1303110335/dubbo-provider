/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

import com.xuleyan.frame.common.util.IPUtils;
import com.xuleyan.provider.service.enums.YesNoMark;
import com.xuleyan.provider.service.exception.PipelineException;
import com.xuleyan.provider.service.valve.Valve;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author xuleyan
 * @version PipelineUtils.java, v 0.1 2021-08-21 9:28 下午
 */
@Slf4j
public class PipelineUtils {

    /**
     * 主机IP地址
     */
    private static String hostIP = IPUtils.getLocalIpAddr();

    public static void invokeValve(Valve executingValve, PipelineContext pipelineContext, String traceId) {
        YesNoMark executingMark = YesNoMark.Y;
        try {
            executingValve.invoke();
        } catch (Exception e) {
            executingMark = YesNoMark.N;
            throw new PipelineException("Failed to invoke" + executingValve, e);
        } finally {
            /**
             * 耗时日志监控 各个valve日志不上报
             */
            log.info("pipeline valve[{}] invoke {}|{}|{}|{}",executingValve.getClass().getSimpleName(), hostIP, executingValve.getLabel(), executingMark.getCode(),traceId);
        }
    }
}
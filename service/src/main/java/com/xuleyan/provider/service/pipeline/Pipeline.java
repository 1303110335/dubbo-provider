/**
 * bianque.com
 * Copyright (C) 2013-2021All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

/**
 *
 * @author xuleyan
 * @version Pipeline.java, v 0.1 2021-08-21 9:09 下午
 */
public interface Pipeline extends AutoCloseable {

    /**
     * pipeline标签(name)
     *
     * @return
     */
    String getLabel();

    /**
     * 创建一次新的执行句柄
     * @return
     */
    PipelineInvocationHandle newInvocation();

    /**
     * 创建一次新的执行，并将此次执行看作另一个执行的子过程
     * @param pipelineContext
     * @return
     */
    PipelineInvocationHandle newInvocation(PipelineContext pipelineContext);
}
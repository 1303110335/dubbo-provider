/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

/**
 *
 * @author xuleyan
 * @version PipelineInvocationHandle.java, v 0.1 2021-08-21 9:06 下午
 */
public interface PipelineInvocationHandle extends PipelineState {

    /**
     *  执行pipeline。
     */
    void invoke();

    /**
     *
     * @param traceId
     * @return
     */
    String traceId(String traceId);
}
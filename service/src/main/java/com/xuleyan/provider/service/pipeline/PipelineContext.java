/**
 * bianque.com
 * Copyright (C) 2013-2021All Rights Reserved.
 */
package com.xuleyan.provider.service.pipeline;

/**
 *
 * @author xuleyan
 * @version PipelineContext.java, v 0.1 2021-08-21 9:10 下午
 */
public interface PipelineContext {

    /**
     * 执行pipeline中下一个valve
     */
    void invokeNext();

    /**
     * 清空参数
     * @param key
     */
    void clearAttribute(String key);
}
/**
 * bianque.com
 * Copyright (C) 2013-2021All Rights Reserved.
 */
package com.xuleyan.provider.service.valve;

import lombok.extern.slf4j.Slf4j;

/**
 * 表示管道上的"阈值"
 * @author xuleyan
 * @version Valve.java, v 0.1 2021-08-21 8:44 下午
 */
public interface Valve extends AutoCloseable {

    /**
     * 调用当前
     * @throws Exception
     */
    public void invoke();

    /**
     * 在一个pipeline中的执行顺序
     *
     * @return
     */
    int order();

    String getLabel();
}
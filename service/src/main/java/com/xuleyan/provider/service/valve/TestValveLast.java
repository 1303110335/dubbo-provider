/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.valve;

/**
 *
 * @author xuleyan
 * @version TestValve.java, v 0.1 2021-08-21 1:16 下午
 */
public class TestValveLast implements Valve {

    @Override
    public void invoke() {
        System.out.println("doInvoke last");
    }

    @Override
    public int order() {
        return 2;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
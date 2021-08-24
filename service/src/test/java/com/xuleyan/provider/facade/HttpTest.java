/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.facade;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.Test;

/**
 *
 * @author xuleyan
 * @version HttpTest.java, v 0.1 2021-08-23 10:05 下午
 */
public class HttpTest {

    @Test
    public void test() {
        HttpRequest httpRequest = HttpRequest.get("http://localhost:8082/test/value");
        HttpResponse execute = httpRequest.execute();
        if (execute.isOk()) {
            String body = execute.body();
            System.out.println(body);
        } else {
            System.out.println("status:" + execute.getStatus());
        }

    }
}
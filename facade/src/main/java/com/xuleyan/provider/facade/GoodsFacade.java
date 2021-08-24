/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.facade;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author xuleyan
 * @version GoodsFacade.java, v 0.1 2021-07-23 10:21 下午
 */
public interface GoodsFacade {

    public String consumeGoods(String goodsId);

    /**
     * 异步执行方法，由dubbo线程池转为业务线程执行
     * @param name
     * @return
     */
    CompletableFuture<String> sayHello(String name);
}
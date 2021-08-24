/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.facade.impl;

import com.xuleyan.provider.facade.GoodsFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author xuleyan
 * @version GoodsFacadeImpl.java, v 0.1 2021-07-23 10:22 下午
 */
@Service
@Slf4j
public class GoodsFacadeImpl implements GoodsFacade {

    @Override
    public String consumeGoods(String goodsId) {
        log.info("consumeGoods >> 消费商品: {}", goodsId);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("消费异常", e);
        }
        return "consumeGoods :" + goodsId;
    }

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext context = RpcContext.getContext();

        return CompletableFuture.supplyAsync(() -> {
            log.info("context = {}", context.getRemoteHost());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider.";
        });
    }


}
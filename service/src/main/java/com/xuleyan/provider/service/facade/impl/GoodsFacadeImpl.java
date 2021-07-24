/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.facade.impl;

import com.xuleyan.provider.facade.GoodsFacade;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

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
        return "consumeGoods :" + goodsId;
    }
}
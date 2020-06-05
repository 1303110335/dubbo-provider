/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.xuleyan.provider.facade.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xuleyan.provider.facade.UserDubboFacade;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author xuleyan
 * @version UserFacade.java, v 0.1 2020-05-29 11:23 AM xuleyan
 */
@Service
@Component
public class UserFacadeImpl implements UserDubboFacade {

    @Override
    public String dubboHandler() {
        System.out.println("tradeId:" + MDC.get("TRACE_ID"));
        return "this is provider ";
    }

}
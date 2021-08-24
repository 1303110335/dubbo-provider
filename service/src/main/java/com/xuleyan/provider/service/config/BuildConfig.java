/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.config;

import com.xuleyan.provider.service.pipeline.PipelineImpl;
import com.xuleyan.provider.service.utils.SpringBeanUtils;
import com.xuleyan.provider.service.valve.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * @author xuleyan
 * @version BuildConfig.java, v 0.1 2021-08-21 1:14 下午
 */
@Component
@Slf4j
public class BuildConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        TestValve testValve = SpringBeanUtils.registerBean(applicationContext, TestValve.class);
        TestValveFirst testValveFirst = SpringBeanUtils.registerBean(applicationContext, TestValveFirst.class);
        TestValveLast testValveLast = SpringBeanUtils.registerBean(applicationContext, TestValveLast.class);
        PipelineImpl.setValves(new Valve[]{testValveFirst, testValve, testValveLast}, true);
        log.info("成功注册bean : TestValve");
    }


}
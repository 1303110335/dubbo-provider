/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.utils;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author xuleyan
 * @version SpringBeanUtils.java, v 0.1 2021-08-21 8:22 下午
 */
public class SpringBeanUtils {

    /**
     * 注册bean到容器中
     * @param applicationContext
     * @param beanClass
     */
    public static <T> T registerBean(ApplicationContext applicationContext, Class<T> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        genericBeanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_NAME);
        genericBeanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
        getRegistry(applicationContext).registerBeanDefinition(beanClass.getSimpleName(), genericBeanDefinition);
        return (T)applicationContext.getBean(beanClass.getSimpleName());
    }

    /**
     * 获取bean定义注册
     * @param applicationContext
     * @return
     */
    private static BeanDefinitionRegistry getRegistry(ApplicationContext applicationContext) {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        ConfigurableListableBeanFactory beanFactory = configurableApplicationContext.getBeanFactory();
        return (DefaultListableBeanFactory)beanFactory;
    }


}
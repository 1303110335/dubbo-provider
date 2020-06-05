/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.xuleyan.provider.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author xuleyan
 * @version AspectService.java, v 0.1 2020-06-02 4:10 PM xuleyan
 */
@Aspect
@Component
public class AspectService {
    //com.xuleyan.provider.facade.impl包下的所有类的所有方法
//    @Before(value="execution(* com.xuleyan.provider.facade.impl.*.*(..))")
//    public void before(JoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        String name = joinPoint.getSignature().getName();
//        System.out.println("方法前****切面方法**"+name+"***"+ Arrays.toString(args));
//    }

//    @After(value="execution(* com.xuleyan.provider.facade.impl.*.*(..))")
//    public void after(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        String name = joinPoint.getSignature().getName();
//        System.out.println("方法后****切面方法**"+name+"***"+ Arrays.toString(args));
//    }
//    @AfterReturning(value="execution(* com.xuleyan.provider.facade.impl.*.*(..))" ,returning = "result")
//    public void afterRunning(JoinPoint joinPoint,Object result){
//        Object[] args = joinPoint.getArgs();
//        String name = joinPoint.getSignature().getName();
//        System.out.println("方法返回后****切面方法**"+name+"***"+ Arrays.toString(args)+"***"+result);
//    }
    @Around(value="execution(* com.xuleyan.provider.facade.impl.*.*(..))")
    public Object rounding(ProceedingJoinPoint joinPoint) throws Throwable {

        // ac1015c01591085642970100117898
        String traceId = MDC.get("TRACE_ID");
        long start = System.currentTimeMillis();
        System.out.println("环绕方法开始****");
        Object proceed = null;
        try {
            Object[] args = joinPoint.getArgs();
            proceed = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throw new Throwable("方法调用失败");
        }
        System.out.println("环绕方法结束****");
        long end = System.currentTimeMillis();
        System.out.println("****方法执行时间**"+(end-start));
        return proceed;
    }

    @AfterThrowing(value = "execution (* com.xuleyan.provider.facade.impl.*.*(..))", throwing = "e")
    public void throwException(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常方法调用:" + methodName + " 异常信息" + e);
    }
}
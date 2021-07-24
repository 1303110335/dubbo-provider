//package com.xuleyan.provider.service.facade.impl;
//
//import com.xuleyan.provider.service.config.RedissonConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * fshows.com
// * Copyright (C) 2013-2020 All Rights Reserved.
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserFacadeImplTest {
//
////    @Autowired
////    private UserFacadeImpl userFacade;
//
//    @Autowired
//    private RedissonConfig redissonConfig;
//
//    @Test
//    public void dubboHandler() {
//        RedissonClient client = redissonConfig.redissonClient();
//        RLock anyLock = client.getLock("anyLock");
//        anyLock.lock(10, TimeUnit.SECONDS);
//
////        anyLock.tryLock()
//
////        try {
////            TimeUnit.SECONDS.sleep(10);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
//
//}
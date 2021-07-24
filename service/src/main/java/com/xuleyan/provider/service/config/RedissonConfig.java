/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.xuleyan.provider.service.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuleyan
 * @version RedissonConfig.java, v 0.1 2020-06-03 12:52 PM xuleyan
 */

//@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        String redisUrl = String.format("redis://%s:%s", redisProperties.getHost() + "", redisProperties.getPort() + "");
//        config.useSingleServer().setAddress(redisUrl).setPassword(redisProperties.getPassword());
//        config.useSingleServer().setDatabase(3);
//        return Redisson.create(config);
//    }
}
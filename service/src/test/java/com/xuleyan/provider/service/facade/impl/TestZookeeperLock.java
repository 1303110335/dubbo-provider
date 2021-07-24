package com.xuleyan.provider.service.facade.impl;

import com.xuleyan.frame.extend.lock.DistributedLock;
import com.xuleyan.frame.extend.lock.ZookeeperDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class TestZookeeperLock {

    CuratorFramework client = null;
    DistributedLock distributedLock = null;

    @Before
    public void before() {
        //创建zookeeper的客户端
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(100, 3);
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();
        distributedLock = new ZookeeperDistributedLock(client, "/curator");
    }

    @Test
    public void zookeeperLock() throws Exception {
        distributedLock.lock("lock");
        System.out.printf("mutex");
        distributedLock.unlock("lock");
    }

    @Test
    public void testTryLock() throws Exception {
        boolean lock = distributedLock.tryLock("lock");
        if (lock) {
            System.out.printf("mutex try lock");
        }
        distributedLock.unlock("lock");
    }

    @After
    public void destroy() {
        client.close();
    }


}

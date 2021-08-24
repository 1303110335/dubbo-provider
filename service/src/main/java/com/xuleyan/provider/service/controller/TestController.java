/**
 * bianque.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.xuleyan.provider.service.controller;

import com.xuleyan.provider.service.pipeline.Pipeline;
import com.xuleyan.provider.service.pipeline.PipelineImpl;
import com.xuleyan.provider.service.pipeline.PipelineInvocationHandle;
import com.xuleyan.provider.service.valve.TestValve;
import com.xuleyan.provider.service.valve.TestValveFirst;
import com.xuleyan.provider.service.valve.TestValveLast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * localhost:8082/test/value
 * @author xuleyan
 * @version TestController.java, v 0.1 2021-08-21 8:19 下午
 */
@RestController
@RequestMapping("test/")
public class TestController {

    @GetMapping("value")
    public String testValue() {
        Pipeline pipeline = new PipelineImpl();
        PipelineInvocationHandle pipelineInvocationHandle = pipeline.newInvocation();
        pipelineInvocationHandle.invoke();
        return "success";
    }

}
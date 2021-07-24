package com.xuleyan.provider.service;

import com.xuleyan.frame.tracer.annotation.EnableTracer;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xuleyan.provider.*")
@DubboComponentScan({"com.xuleyan.provider.*", "com.xuleyan.frame.tracer"})
@EnableTracer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

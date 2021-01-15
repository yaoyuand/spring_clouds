package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用nacos进行服务注册(服务消费者)
 * */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumer83.class,args);
    }
}

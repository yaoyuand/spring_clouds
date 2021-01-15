package com.cloud.guigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用nacos进行服务注册(服务提供者)
 * */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaPayment9001.class,args);
    }
}

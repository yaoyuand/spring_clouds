package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //hystrix 降级注解生效注解
public class HystrixPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain.class,args);
    }
}

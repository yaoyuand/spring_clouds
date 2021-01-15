package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos配置管理
 * application中配置的spring.profiles.active对应配置管理中的DATAID
 * bootstrap中配置spring.config.namespace对应配置管理中的命名空间
 * bootstrap中配置spring.config.group对应配置管理中的group
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3377.class,args);
    }
}

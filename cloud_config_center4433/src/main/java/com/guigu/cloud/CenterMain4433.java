package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 自动全部刷新
 * http://localhost:4433/actuator/bus-refresh
 * 刷新指定服务
 * http://localhost:4433/actuator/bus-refresh/config-client:4455
 * */
@SpringBootApplication
@EnableConfigServer
public class CenterMain4433 {
    public static void main(String[] args) {
        SpringApplication.run(CenterMain4433.class,args);
    }
}

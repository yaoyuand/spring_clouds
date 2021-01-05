package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CenterMain4433 {
    public static void main(String[] args) {
        SpringApplication.run(CenterMain4433.class,args);
    }
}

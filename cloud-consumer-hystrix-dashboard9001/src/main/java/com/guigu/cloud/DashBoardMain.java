package com.guigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //图形化监控注解
public class DashBoardMain {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardMain.class,args);
    }
}

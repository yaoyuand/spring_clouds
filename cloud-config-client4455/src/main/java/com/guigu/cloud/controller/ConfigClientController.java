package com.guigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope注解作用:
 * 监控中刷新配置文件值，但是想要生效需要手动执行以下post接口
 * curl -X POST "http://localhost:4455/actuator/refresh"
 * curl -X POST作用是在cmd窗口中指定发送接口为post请求
 * */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String config;

    @GetMapping("/config")
    public String config(){
        return config;
    }
}

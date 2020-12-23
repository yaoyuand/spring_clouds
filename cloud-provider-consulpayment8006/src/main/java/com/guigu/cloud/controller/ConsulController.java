package com.guigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsulController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/consul/all")
    public String consul(){

        return "consul service port:"+port+"  ,UUID:"+ UUID.randomUUID().toString();
    }
}

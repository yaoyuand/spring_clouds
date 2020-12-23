package com.guigu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulController {
    private final static String BASE_PATH="http://cloud-provider-consul";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/consul/all")
    public String consul(){
        return restTemplate.getForObject(BASE_PATH+"/consul/all",String.class);
    }
}

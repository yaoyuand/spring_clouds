package com.guigu.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZkOrderController {
    private static final String BASE_PATH="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment")
    public String zkOrder(){
        String result=this.restTemplate.getForObject(BASE_PATH+"/payment",String.class);
        return result;
    }
}

package com.guigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * */
@RestController
@Slf4j
public class OrderController {
    @Value("${order.use-url}")
    private String path;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
    public String order(@PathVariable("id")String id){
        return restTemplate.getForObject(path+"/payment/"+id,String.class);
    }
}

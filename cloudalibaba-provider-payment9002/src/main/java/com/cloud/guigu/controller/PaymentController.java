package com.cloud.guigu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public String payment(@PathVariable("id")String id){
        return "port:"+port+",id:"+id;
    }

}

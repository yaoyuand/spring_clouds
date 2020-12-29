package com.guigu.cloud.controller;

import com.guigu.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFallbackController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/order/{id}")
    public String order(@PathVariable("id") Integer id){
        return orderService.hystrix_timeOut(id);
    }
}

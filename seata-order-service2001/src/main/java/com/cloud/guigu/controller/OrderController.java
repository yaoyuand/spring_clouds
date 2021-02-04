package com.cloud.guigu.controller;

import com.cloud.guigu.domain.Order;
import com.cloud.guigu.service.OrderService;
import com.guigu.cloud.entity.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResultData order(Order order){
        return orderService.placeOrder(order);
    }
}

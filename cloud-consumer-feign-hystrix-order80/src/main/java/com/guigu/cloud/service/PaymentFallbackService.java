package com.guigu.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements OrderService {

    @Override
    public String hystrix_ok(Integer id) {
        return "======payment  hystrix_ok======";
    }

    @Override
    public String hystrix_timeOut(Integer id) {
        return "======payment  hystrix_timeOut======";
    }
}

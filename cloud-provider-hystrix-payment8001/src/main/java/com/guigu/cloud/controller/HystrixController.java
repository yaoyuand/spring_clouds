package com.guigu.cloud.controller;

import com.guigu.cloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HystrixController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        String result=this.hystrixService.hystrix_ok(id);
        log.info("ok:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String hystrix_timeOut(@PathVariable("id") Integer id){
        String result=this.hystrixService.hystrix_timeOut(id);
        log.info("timeout:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=this.hystrixService.paymentCircuitBreaker(id);
        return result;
    }
}

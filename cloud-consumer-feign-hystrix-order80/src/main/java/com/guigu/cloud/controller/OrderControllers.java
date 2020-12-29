package com.guigu.cloud.controller;

import com.guigu.cloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "handelBack")
public class OrderControllers {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumers/payment/hystrix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        String result=this.orderService.hystrix_ok(id);
        log.info("consumer ok:"+result);
        return result;
    }

    @GetMapping("/consumers/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String hystrix_timeOut(@PathVariable("id") Integer id){
        String result=this.orderService.hystrix_timeOut(id);
        log.info("consumer timeout:"+result);
        return result;
    }

    /**
     * DefaultProperties和HystrixCommand结合的方式
     * 先查找HystrixCommand中fallbackMethod，如果不存在再调用DefaultProperties中defaultFallback方法
     *这样编写全局的fallback可以使代码整洁
     * */
    public String handelBack(){
        return "当前服务繁忙，请10分钟后再试!";
    }
}

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
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        String result=this.orderService.hystrix_ok(id);
        log.info("consumer ok:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "handelBack",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")})
    public String hystrix_timeOut(@PathVariable("id") Integer id){
        String result=this.orderService.hystrix_timeOut(id);
        log.info("consumer timeout:"+result);
        return result;
    }

    /**
     * HystrixCommand配置服务降级
     * fallbackMethod 降级调用方法
     * commandProperties 配置参数
     * execution.isolation.thread.timeoutInMilliseconds 接口响应请求时间上限
     * 注意采用HystrixCommand方式配置服务降级必须要在每个方法上面都配置，代码会很臃肿
     * */
    public String handelBack(){
        return "当前服务繁忙，请10分钟后再试!";
    }
}

package com.guigu.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {
    @Value("${server.port}")
    private String port;

    public String hystrix_ok(Integer id){
        return "name:"+Thread.currentThread().getName()+" port:"+port+" ,is ok:"+id;
    }

    /**
     * 配置降级，熔断机制
     * fallbackMethod:兜底方法
     * commandProperties:调用兜底方法要求
     * execution.isolation.thread.timeoutInMilliseconds 配置方法响应最大时间
     * */
    @HystrixCommand(fallbackMethod = "handelBack",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String hystrix_timeOut(Integer id){
        Integer times=5;
        try {
            TimeUnit.SECONDS.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "name:"+Thread.currentThread().getName()+" port:"+port+" ,is time out "+times+" ,id:"+id;
    }

    public String handelBack(Integer id){
        return "当前服务繁忙，请稍后重试!";
    }


    //断路器配置

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//断路器是否开启
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//设置将使电路跳闸的最小请求数(必须要达到设定次数之后才会生效，没有达到不会生效)
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//电路跳闸后拒绝请求的时间，然后允许再次尝试确定是否应再次闭合电路
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id值不能小于0");
        }
        String uuid= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+" \t"+"调用成功，流水号为:"+uuid;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "传递id值不能小于0，请稍后重试";
    }

}

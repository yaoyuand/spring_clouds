package com.cloud.guigu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.guigu.service.OrderService;
import com.guigu.cloud.entity.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    private String path="http://provider-test";

    @GetMapping("/consumer/payment/{id}")
    @SentinelResource(value = "consumer/payment")
    public ResultData consumer(@PathVariable("id")String id){
        ResultData resultData=this.restTemplate.getForObject(path+"/payment/"+id,ResultData.class);
        return resultData;
    }

    @GetMapping("/fallback/payment/{id}")
    @SentinelResource(value = "fallback/payment",fallback = "fallback")
    public ResultData fallbackTest(@PathVariable("id")String id){
        ResultData resultData=this.restTemplate.getForObject(path+"/payment/"+id,ResultData.class);
        return resultData;
    }

    @GetMapping("/blockHandel/payment/{id}")
    @SentinelResource(value = "blockHandel/payment",blockHandler = "blockHandel")
    public ResultData blockHandelTest(@PathVariable("id")String id){
        ResultData resultData=this.restTemplate.getForObject(path+"/payment/"+id,ResultData.class);
        return resultData;
    }

    @GetMapping("/both/payment/{id}")
    @SentinelResource(value = "blockHandel/payment",fallback = "fallback",blockHandler = "blockHandel")
    public ResultData bothTest(@PathVariable("id")String id){
        ResultData resultData=this.restTemplate.getForObject(path+"/payment/"+id,ResultData.class);
        return resultData;
    }

    public ResultData fallback(@PathVariable("id")String id,Throwable throwable){
        return ResultData.error("进入fallback统一处理方法");
    }

    public ResultData blockHandel(@PathVariable("id")String id, BlockException exception){
        return ResultData.error("进入fallback统一处理方法");
    }


    @GetMapping("/openfeign/order/{id}")
    public ResultData openfeign(@PathVariable("id")String id){
        return this.orderService.getId(id);
    }

}

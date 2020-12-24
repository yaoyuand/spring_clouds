package com.guigu.cloud.controller;

import com.guigu.cloud.config.MyLb;
import com.guigu.cloud.entity.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class LoadBalanceController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLb myLb;

    @GetMapping("/loadbalance/{id}")
    public ResultData selectById(@PathVariable("id")String id){
        //获取全部服务类
        List<ServiceInstance> list=this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        //获取下一个服务类
        ServiceInstance serviceInstance=this.myLb.get(list);
        return this.restTemplate.getForObject(serviceInstance.getUri()+"/payment/"+id,ResultData.class);
    }
}

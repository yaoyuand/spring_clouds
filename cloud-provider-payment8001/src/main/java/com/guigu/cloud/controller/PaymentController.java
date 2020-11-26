package com.guigu.cloud.controller;

import com.guigu.cloud.entity.Payment;
import com.guigu.cloud.entity.ResultData;
import com.guigu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/{id}")
    public ResultData selectById(@PathVariable("id")String id){
        Payment payment=this.paymentService.selectById(id);
        if(payment==null){
            log.info("查询失败!");
            return ResultData.error("查询失败!");
        }else{
            log.info("查询成功");
        }
        return new ResultData("200","查询成功,serverPort:"+serverPort,payment);
    }

    @PostMapping("/payment/save")
    public ResultData save(@RequestBody Payment payment){
        Long id=this.paymentService.save(payment);
        if(id==null){
            log.info("插入失败!");
            return ResultData.error("插入失败!");
        }else{
            log.info("插入成功!");
        }
        return ResultData.success(id);
    }

    @GetMapping("/discover")
    public Object discover(){
        List<String> serviceList=discoveryClient.getServices();
        log.info("获取服务名称为:");
        serviceList.forEach(data->{
            log.info("*********serviceName:"+data);
        });
        log.info("获取服务信息为:");
        List<ServiceInstance> serviceInstances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        serviceInstances.forEach(serviceInstance -> {
            log.info("host:"+serviceInstance.getHost()+" instanceId:"+serviceInstance.getInstanceId()+" scheme:"+serviceInstance.getScheme()+" port:"+serviceInstance.getPort()+" url:"+serviceInstance.getUri());
        });

        return discoveryClient;
    }
}

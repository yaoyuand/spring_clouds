package com.guigu.cloud.controller;

import com.guigu.cloud.entity.Payment;
import com.guigu.cloud.entity.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


//    private static String BASE_PATH="http://localhost:8001";
    private static String BASE_PATH="http://CLOUD-PAYMENT-SERVICE";//通过服务名称调用

    @GetMapping("/order/{id}")
    public ResultData selectById(@PathVariable("id")String id){
        return restTemplate.getForObject(BASE_PATH+"/payment/"+id,ResultData.class);
    }

    @GetMapping("/order/save")
    public ResultData save(Payment payment) {
        return restTemplate.postForObject(BASE_PATH+"/payment/save",payment,ResultData.class);
    }

    @GetMapping("/entity/order/{id}")
    public ResultData entityId(@PathVariable("id")String id){
        ResponseEntity<ResultData> resultDataResponseEntity=restTemplate.getForEntity(BASE_PATH+"/payment/"+id,ResultData.class);
        if(resultDataResponseEntity.getStatusCode().is2xxSuccessful()){
            return resultDataResponseEntity.getBody();
        }
        return ResultData.error();
    }

    @GetMapping("/order/zipkin")
    public String zipkin(){
        ResponseEntity<String> resultDataResponseEntity=restTemplate.getForEntity(BASE_PATH+"/zipkin",String.class);
        return resultDataResponseEntity.getBody();
    }


}

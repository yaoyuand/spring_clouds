package com.guigu.cloud.service;

import com.guigu.cloud.entity.ResultData;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-Payment-service")
public interface OpenFignService {
    @GetMapping("/payment/{id}")
    ResultData selectById(@PathVariable("id")String id);
}

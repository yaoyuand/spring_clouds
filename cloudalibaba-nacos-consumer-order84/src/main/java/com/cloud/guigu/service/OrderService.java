package com.cloud.guigu.service;

import com.guigu.cloud.entity.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "provider-test",fallback = OrderServiceFallback.class)
public interface OrderService {
    @GetMapping("/payment/{id}")
    ResultData getId(@PathVariable("id")String id);
}

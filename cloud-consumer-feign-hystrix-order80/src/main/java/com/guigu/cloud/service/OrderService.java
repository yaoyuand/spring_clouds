package com.guigu.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient注解中fallback配置当被调用服务出现宕机或者错误时调用者本身进行服务降级
 * 实现降级方法同业务方法的解耦
 * */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface OrderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String hystrix_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String hystrix_timeOut(@PathVariable("id") Integer id);


}

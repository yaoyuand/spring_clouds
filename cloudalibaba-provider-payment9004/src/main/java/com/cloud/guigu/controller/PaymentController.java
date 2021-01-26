package com.cloud.guigu.controller;

import com.guigu.cloud.entity.Payment;
import com.guigu.cloud.entity.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class PaymentController {
    public static Map<Long, Payment> map=new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"11"));
        map.put(2L,new Payment(2L,"22"));
        map.put(3L,new Payment(3L,"33"));
        map.put(4L,new Payment(4L,"44"));
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public ResultData getId(@PathVariable("id")String id){
        Payment payment=map.get(id);
        return ResultData.success(payment+":"+port);
    }
}

package com.guigu.cloud.controller;

import com.guigu.cloud.entity.Payment;
import com.guigu.cloud.entity.ResultData;
import com.guigu.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public ResultData selectById(@PathVariable("id")String id){
        Payment payment=this.paymentService.selectById(id);
        if(payment==null){
            log.info("查询失败!");
            return ResultData.error("查询失败!");
        }else{
            log.info("查询成功");
        }
        return ResultData.success(payment);
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
}

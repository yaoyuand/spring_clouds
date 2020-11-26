package com.guigu.cloud.service;

import com.guigu.cloud.entity.Payment;
import com.guigu.cloud.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public Payment selectById(String id){
        return paymentMapper.selectById(id);
    }

    public Long save(Payment payment){
        return this.paymentMapper.save(payment);
    }
}

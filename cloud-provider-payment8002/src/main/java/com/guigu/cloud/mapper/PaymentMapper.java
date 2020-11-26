package com.guigu.cloud.mapper;

import com.guigu.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    Payment selectById(String id);

    Long save(Payment payment);
}

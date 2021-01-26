package com.cloud.guigu.service;

import com.guigu.cloud.entity.ResultData;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService{
    public ResultData getId(String id){

        return ResultData.error("连接超时");
    }
}

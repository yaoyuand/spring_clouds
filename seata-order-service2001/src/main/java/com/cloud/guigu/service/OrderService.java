package com.cloud.guigu.service;

import com.cloud.guigu.domain.Order;
import com.guigu.cloud.entity.ResultData;

public interface OrderService {

    /**
     * 用户下订单
     * */
    ResultData placeOrder(Order order);
}

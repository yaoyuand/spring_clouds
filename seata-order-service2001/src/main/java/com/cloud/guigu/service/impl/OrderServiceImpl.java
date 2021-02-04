package com.cloud.guigu.service.impl;

import com.cloud.guigu.dao.OrderMapper;
import com.cloud.guigu.domain.Order;
import com.cloud.guigu.service.AccountService;
import com.cloud.guigu.service.OrderService;
import com.cloud.guigu.service.StorageService;
import com.guigu.cloud.entity.ResultData;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp_tx_group",rollbackFor = Exception.class)
    public ResultData placeOrder(Order order) {
        log.info("开始创建订单信息");
        this.orderMapper.save(order);
        log.info("创建订单信息结束");

        log.info("开始修改库存");
        this.storageService.update(order.getProductId(),order.getCount());
        log.info("修改库存结束");

        log.info("开始修改账户");
        this.accountService.update(order.getUserId(),order.getCount());
        log.info("修改账户结束");

        log.info("开始修改订单状态");
        this.orderMapper.update(order.getUserId(),0);
        log.info("修改订单状态结束");
        return ResultData.success();
    }
}

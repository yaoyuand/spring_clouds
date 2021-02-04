package com.cloud.guigu.dao;

import com.cloud.guigu.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    /**
     * 新增订单
     * */
    void save(Order order);

    /**
     * 修改订单状态
     * @param userId  用户id
     * @param status  订单状态
     * */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

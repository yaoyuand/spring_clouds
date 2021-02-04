package com.cloud.guigu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单类
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;

    private Long userId;//用户id

    private Long productId;//产品id

    private Integer count;//数量

    private BigDecimal money;//金额

    private Integer status;//状态，0：处理中，1:已完成
}

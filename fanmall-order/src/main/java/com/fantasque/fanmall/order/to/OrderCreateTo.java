package com.fantasque.fanmall.order.to;

import com.fantasque.fanmall.order.entity.OrderEntity;
import com.fantasque.fanmall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class OrderCreateTo {

    private OrderEntity order;

    private List<OrderItemEntity> orderItems;

    /** 订单计算的应付价格 **/
    private BigDecimal payPrice;

    /** 运费 **/
    private BigDecimal fare;

}
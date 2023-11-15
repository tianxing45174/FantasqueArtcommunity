package com.fantasque.fanmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.to.mq.SeckillOrderTo;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.order.entity.OrderEntity;
import com.fantasque.fanmall.order.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 订单
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:22:12
 */
public interface OrderService extends IService<OrderEntity> {

    void createSeckillOrder(SeckillOrderTo orderTo);

    @Transactional(rollbackFor = Exception.class)
    String handlePayResult(PayAsyncVo asyncVo);

    PageUtils queryPageWithItem(Map<String, Object> params);

    PayVo getOrderPay(String orderSn);

    void closeOrder(OrderEntity orderEntity);

    OrderEntity getOrderByOrderSn(String orderSn);

    PageUtils queryPage(Map<String, Object> params);

    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    // @Transactional(isolation = Isolation.READ_COMMITTED) 设置事务的隔离级别
    // @Transactional(propagation = Propagation.REQUIRED)   设置事务的传播级别
    @Transactional(rollbackFor = Exception.class)
    // @GlobalTransactional(rollbackFor = Exception.class)
    SubmitOrderResponseVo submitOrder(OrderSubmitVo vo);
}


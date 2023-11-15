package com.fantasque.fanmall.ware.listener;

import com.fantasque.common.to.OrderTo;
import com.fantasque.common.to.mq.StockLockedTo;
import com.fantasque.fanmall.ware.service.WareSkuService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author LaFantasque
 * @version 1.0
 */
@RabbitListener(queues = "stock.release.stock.queue")
@Service
public class StockReleaseListener {
    @Autowired
    private WareSkuService wareSkuService;

    /**
     * 1、库存自动解锁
     *  下订单成功，库存锁定成功，接下来的业务调用失败，导致订单回滚。之前锁定的库存就要自动解锁
     *
     *  2、订单失败
     *      库存锁定失败
     *
     *   只要解锁库存的消息失败，一定要告诉服务解锁失败
     */
    @RabbitHandler
    public void handleStockLockedRelease(StockLockedTo to, Message message, Channel channel) throws IOException {
//        log.info("******收到解锁库存的信息******");
        System.out.println("******收到解锁库存的信息A******");
        try {

            //当前消息是否被第二次及以后（重新）派发过来了
            // Boolean redelivered = message.getMessageProperties().getRedelivered();

            //解锁库存
            wareSkuService.unlockStock(to);
            System.out.println("******aaaaaaaaaaaaaa******");
            // 手动删除消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            // 解锁失败 将消息重新放回队列，让别人消费
            System.out.println("******bbbbbbbbbbbbbbbbbb******");
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }

    @RabbitHandler
    public void handleOrderCloseRelease(OrderTo orderTo, Message message, Channel channel) throws IOException {
//        log.info("******收到订单关闭，准备解锁库存的信息******");
        System.out.println("******收到解锁库存的信息B******");
        try {
            wareSkuService.unlockStock(orderTo);
            System.out.println("******AAAAAAAAAAAAAAAAA******");
            // 手动删除消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            // 解锁失败 将消息重新放回队列，让别人消费
            System.out.println("******BBBBBBBBBBBBBBBBB******");
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}

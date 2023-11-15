package com.fantasque.fanmall.seckill.service;

import com.fantasque.fanmall.seckill.to.SeckillSkuRedisTo;

import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
public interface SeckillService {

    SeckillSkuRedisTo getSkuSeckilInfo(Long skuId);

    List<SeckillSkuRedisTo> getCurrentSeckillSkus();

    String kill(String killId, String key, Integer num) throws InterruptedException;

    void uploadSeckillSkuLatest3Days();
}

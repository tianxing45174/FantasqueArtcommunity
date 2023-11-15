package com.fantasque.fanmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.to.OrderTo;
import com.fantasque.common.to.SkuHasStockTo;
import com.fantasque.common.to.mq.StockLockedTo;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.ware.entity.WareSkuEntity;
import com.fantasque.fanmall.ware.vo.WareSkuLockVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:31:13
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    void unlockStock(StockLockedTo to);

    @Transactional(rollbackFor = Exception.class)
    void unlockStock(OrderTo orderTo);

    @Transactional(rollbackFor = Exception.class)
    boolean orderLockStock(WareSkuLockVo vo);

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockTo> getSkusHasStock(List<Long> skuIds);
}


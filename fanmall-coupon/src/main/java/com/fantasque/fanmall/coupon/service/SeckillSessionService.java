package com.fantasque.fanmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.coupon.entity.SeckillSessionEntity;

import java.util.List;
import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 14:54:38
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    List<SeckillSessionEntity> getLates3DaySession();

    PageUtils queryPage(Map<String, Object> params);
}


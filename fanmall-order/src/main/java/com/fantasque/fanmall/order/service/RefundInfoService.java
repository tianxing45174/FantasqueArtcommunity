package com.fantasque.fanmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:22:12
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


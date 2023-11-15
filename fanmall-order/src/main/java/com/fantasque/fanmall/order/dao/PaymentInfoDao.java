package com.fantasque.fanmall.order.dao;

import com.fantasque.fanmall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:22:11
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}

package com.fantasque.fanmall.coupon.dao;

import com.fantasque.fanmall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 14:54:38
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}

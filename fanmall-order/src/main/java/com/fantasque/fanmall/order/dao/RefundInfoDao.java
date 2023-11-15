package com.fantasque.fanmall.order.dao;

import com.fantasque.fanmall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:22:12
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}

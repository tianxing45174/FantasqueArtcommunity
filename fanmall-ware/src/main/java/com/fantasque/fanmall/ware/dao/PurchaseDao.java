package com.fantasque.fanmall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fantasque.fanmall.ware.entity.PurchaseEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:31:13
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}

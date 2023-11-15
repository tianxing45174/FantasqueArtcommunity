package com.fantasque.fanmall.product.dao;

import com.fantasque.fanmall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 01:04:14
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}

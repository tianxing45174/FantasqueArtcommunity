package com.fantasque.fanmall.member.dao;

import com.fantasque.fanmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:08:55
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}

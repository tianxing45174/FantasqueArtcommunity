package com.fantasque.fanmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.member.entity.MemberReceiveAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 会员收货地址
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:08:55
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    List<MemberReceiveAddressEntity> getAddress(Long memberId);

    PageUtils queryPage(Map<String, Object> params);
}


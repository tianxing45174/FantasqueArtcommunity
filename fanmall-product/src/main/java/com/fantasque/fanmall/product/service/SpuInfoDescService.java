package com.fantasque.fanmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 01:04:14
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);
}


package com.fantasque.fanmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.product.entity.SpuInfoEntity;
import com.fantasque.fanmall.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 01:04:14
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    SpuInfoEntity getSpuInfoBySkuId(Long skuId);

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);
}


package com.fantasque.fanmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.product.entity.ProductAttrValueEntity;
import com.fantasque.fanmall.product.entity.SpuInfoEntity;
import com.fantasque.fanmall.product.vo.BaseAttrs;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 01:04:14
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveProductAttr(List<BaseAttrs> baseAttrs, SpuInfoEntity infoEntity);

    List<ProductAttrValueEntity> baseAttrlistforspu(Long spuId);

    void updateSpuAttr(Long spuId, List<ProductAttrValueEntity> entities);
}


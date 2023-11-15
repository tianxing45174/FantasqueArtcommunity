package com.fantasque.fanmall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;

}

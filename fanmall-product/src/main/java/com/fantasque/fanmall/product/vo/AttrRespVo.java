package com.fantasque.fanmall.product.vo;

import lombok.Data;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class AttrRespVo extends AttrVo{
    /**
     * 所属分组名
     */
    private String groupName;
    /**
     * 所属分类名
     */
    private String catelogName;
    /**
     * 三级分类
     */
    private Long[] catelogPath;
}

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
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<Attr> attrs;

}

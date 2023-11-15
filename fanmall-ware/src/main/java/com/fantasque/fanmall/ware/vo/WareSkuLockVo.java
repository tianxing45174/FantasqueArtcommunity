package com.fantasque.fanmall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class WareSkuLockVo {

    private String orderSn;

    /** 需要锁住的所有库存信息 **/
    private List<OrderItemVo> locks;

}

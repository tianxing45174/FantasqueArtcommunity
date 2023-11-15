package com.fantasque.common.to.mq;

import lombok.Data;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class StockLockedTo {

    /** 库存工作单的id **/
    private Long id;

    /** 工作单详情的所有信息 **/
    private StockDetailTo detailTo;
}

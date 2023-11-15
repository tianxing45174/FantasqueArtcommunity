package com.fantasque.fanmall.order.vo;

import com.fantasque.fanmall.order.entity.OrderEntity;
import lombok.Data;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class SubmitOrderResponseVo {

    private OrderEntity order;

    /** 错误状态码 **/
    private Integer code;


}

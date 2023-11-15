package com.fantasque.fanmall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}
package com.fantasque.fanmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
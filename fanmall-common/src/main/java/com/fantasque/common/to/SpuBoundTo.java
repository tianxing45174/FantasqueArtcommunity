package com.fantasque.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class SpuBoundTo {

    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}

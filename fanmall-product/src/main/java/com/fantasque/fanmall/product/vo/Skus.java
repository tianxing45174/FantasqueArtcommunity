package com.fantasque.fanmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class Skus {
    private List<Attr> attr;
    private String skuName;
    private BigDecimal price;
    private String skuTitle;
    private String skuSubtitle;
    private List<Images> images;
    private List<String> descar;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;

//    @Data
//    public class Attr {
//
//        private Long attrId;
//        private String attrName;
//        private String attrValue;
//
//    }
//    @Data
//    public class Images {
//
//        private String imgUrl;
//        private int defaultImg;
//
//    }
//    @Data
//    public class MemberPrice {
//
//        private Long id;
//        private String name;
//        private BigDecimal price;
//
//    }
}

package com.fantasque.common.constant;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class ProductConstant {

    public enum AttrEnum{
        ATTR_TYPE_BASE(1,"基本属性"), ATTR_TYPE_SALE(0,"销售属性");
        private int code;
        private String msg;
        AttrEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public enum StatusEnum{
        NEW_SPU(-1,"新建"), SPU_DOWN(0,"商品下架"), SPU_UP(1,"商品上架");
        private int code;
        private String msg;
        StatusEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

}

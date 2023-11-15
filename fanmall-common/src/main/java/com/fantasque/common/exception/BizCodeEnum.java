package com.fantasque.common.exception;

/**
 *
 * 错误码和错误信息定义类
 * 1、定义为5位数字
 * 2、前两位表示业务场景，后三位表示错误码。例如
 * 10001表示 10：通用 001：系统未知异常
 * 3、错误码需维护错误描述，定义为枚举型
 * 错误码列表
 * 10：通用
 *  001：参数格式校验
 * 11：商品
 * 12：订单
 * 13：购物车
 * 14：物流
 * 15：用户
 *
 *
 */
public enum BizCodeEnum {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式校验失败"),
    TO_MANY_REQUEST(10002,"请求流量过大，请稍后再试"),
    SMS_CODE_EXCEPTION(10002,"验证码获取频率太高，请稍后再试"),
    PRODUCT_UP_EXCEPTION(11000,"商品上架异常"),
    USER_EXIST_EXCEPTION(15001,"存在相同的用户"),
    PHONE_EXIST_EXCEPTION(15002,"存在相同的手机号"),
    NO_STOCK_EXCEPTION(21000,"商品库存不足"),
    LOGINACCT_PASSWORD_EXCEPTION(15003,"账号或密码错误"),
    ;

    private int code;
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

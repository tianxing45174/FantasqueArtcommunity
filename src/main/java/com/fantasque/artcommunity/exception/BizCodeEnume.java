package com.fantasque.artcommunity.exception;

/**
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
 */
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式校验失败");

    private int code;
    private String msg;

    BizCodeEnume(int code, String msg) {
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

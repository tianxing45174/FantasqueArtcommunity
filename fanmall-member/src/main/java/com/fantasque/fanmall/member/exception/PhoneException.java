package com.fantasque.fanmall.member.exception;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class PhoneException extends RuntimeException {

    public PhoneException() {
        super("存在相同的手机号");
    }
}
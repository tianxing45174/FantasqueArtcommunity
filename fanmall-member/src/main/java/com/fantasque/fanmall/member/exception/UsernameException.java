package com.fantasque.fanmall.member.exception;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class UsernameException extends RuntimeException {


    public UsernameException() {
        super("存在相同的用户名");
    }
}

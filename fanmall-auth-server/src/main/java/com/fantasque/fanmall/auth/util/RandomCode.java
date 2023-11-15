package com.fantasque.fanmall.auth.util;

import java.util.Random;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class RandomCode {
    /**
     * 随机生成6位数的验证码
     * @return String code
     */
    public String getRandomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}

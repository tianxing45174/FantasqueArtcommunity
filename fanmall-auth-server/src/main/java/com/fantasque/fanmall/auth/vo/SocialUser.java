package com.fantasque.fanmall.auth.vo;

import lombok.Data;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class SocialUser {

    private String access_token;

    private String remind_in;

    private long expires_in;

    private String uid;

    private String isRealName;

}

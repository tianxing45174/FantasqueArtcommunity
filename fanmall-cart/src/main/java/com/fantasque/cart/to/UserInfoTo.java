package com.fantasque.cart.to;

import lombok.Data;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    /**
     * 是否临时用户
     */
    private Boolean tempUser = false;

}

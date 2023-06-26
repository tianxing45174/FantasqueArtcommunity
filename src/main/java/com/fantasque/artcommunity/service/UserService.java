package com.fantasque.artcommunity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.artcommunity.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author tianx
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-23 19:01:12
*/
public interface UserService extends IService<User> {

    public User getUserIdByCookie(HttpServletRequest req);

    public boolean login(User user);

    public User findByUserName(String username);
}

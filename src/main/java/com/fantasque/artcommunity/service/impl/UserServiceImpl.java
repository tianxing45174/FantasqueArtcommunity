package com.fantasque.artcommunity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fantasque.artcommunity.entity.User;
import com.fantasque.artcommunity.mapper.UserMapper;
import com.fantasque.artcommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
* @author tianx
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-27 15:29:47
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 在Cookie中获取userId
     * @param req
     * @return
     */
    @Override
    public User getUserIdByCookie(HttpServletRequest req) {
        User user = null;
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("userid")) {
                user = this.getById(cookies[i].getValue());
                break;
            }
        }
        return user;
    }

    @Override
    public boolean login(User user) {
        User thisUser = userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", user.getUsername())
                .eq("password", user.getPassword())
        );
        if (ObjectUtils.isEmpty(thisUser)) {
            return false;
        }

        return true;
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }


}





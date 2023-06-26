package com.fantasque.artcommunity.realm;

import com.fantasque.artcommunity.entity.User;
import com.fantasque.artcommunity.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * @author LaFantasque
 * @version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //根据身份信息//从传过来的token获取到的用户名
        String principal = (String) token.getPrincipal();
        System.out.println("principalprincipal"+principal);

        //在工厂中获取service对象
//        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

        //根据身份信息查询
        User user = userService.findByUserName(principal);
        System.out.println("User:"+user);

        //用户不为空
        if(!ObjectUtils.isEmpty(user)){
            //返回数据库信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
                    ByteSource.Util.bytes("fantasque"), this.getName());
            return simpleAuthenticationInfo;
        }

        return null;
    }
}

package com.fantasque.artcommunity.config;

import com.fantasque.artcommunity.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Configuration
public class ShiroConfig {

//    @Bean
//    public FilterRegistrationBean delegatingFilterProxy(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        proxy.setTargetFilterLifecycle(true);
//        proxy.setTargetBeanName("shiroFilter");
//        filterRegistrationBean.setFilter(proxy);
//        return filterRegistrationBean;
//    }

    //1.创建shiroFilter  //负责拦截所有请求
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager
//            , ServletRequest req
    ){
//        if (req.)
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        req.setAttribute("loginmsg","请先登录");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        //配置系统公共资源
        Map<String,String> map = new HashMap<String,String>();
//        map.put("/user/login","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/user/register","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/jsp/register.jsp","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/jsp/login.jsp","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/jsp/view/error.jsp","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/static/**","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/artworks/**","anon");//anon 设置为公共资源  放行资源放在下面
//        map.put("/jsp/**","anon");

//        map.put("/**","authc");
        //默认认证界面路径---当认证不通过时跳转
        shiroFilterFactoryBean.setLoginUrl("/jsp/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //给安全管理器设置
        securityManager.setRealm(realm);
        ThreadContext.bind(securityManager);
        return securityManager;
    }

    @Bean
    public Realm getRealm(){
        UserRealm realm = new UserRealm();

        //设置hashed凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();

        //设置md5加密
        credentialsMatcher.setHashAlgorithmName("md5");

        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

}
package com.fantasque.fanmall.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        HttpRequest request = exchange.getRequest();
//        System.out.println("-----------------------------------");
//        System.out.println(request.toString());
//        System.out.println("-----------------------------------");
        //获取登录的用户信息
//        MemberResponseVo attribute = (MemberResponseVo) session.getAttribute(LOGIN_USER);

        return chain.filter(exchange);
    }
}

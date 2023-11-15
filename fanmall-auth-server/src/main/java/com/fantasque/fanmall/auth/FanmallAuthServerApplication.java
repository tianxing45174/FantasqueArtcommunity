package com.fantasque.fanmall.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession //整合redis 作为session存储
@EnableFeignClients(basePackages = {"com.fantasque.feign.MemberFeign","com.fantasque.fanmall.auth.feign"})
@EnableDiscoveryClient
@SpringBootApplication
public class FanmallAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanmallAuthServerApplication.class, args);
    }

}

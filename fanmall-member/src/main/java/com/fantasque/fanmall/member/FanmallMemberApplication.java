package com.fantasque.fanmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.fantasque.fanmall.member.feign")
@SpringBootApplication
public class FanmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanmallMemberApplication.class, args);
    }

}

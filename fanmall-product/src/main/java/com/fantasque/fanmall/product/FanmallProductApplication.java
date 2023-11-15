package com.fantasque.fanmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.fantasque.fanmall.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.fantasque.fanmall.product.dao")
public class FanmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanmallProductApplication.class, args);
    }

}

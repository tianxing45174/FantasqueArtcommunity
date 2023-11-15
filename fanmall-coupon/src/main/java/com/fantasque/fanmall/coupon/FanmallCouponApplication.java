package com.fantasque.fanmall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.fantasque.fanmall.coupon.dao")
public class FanmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanmallCouponApplication.class, args);
    }

}

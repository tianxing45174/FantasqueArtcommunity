package com.fantasque.fanmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FanmallThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FanmallThirdPartyApplication.class, args);
	}

}

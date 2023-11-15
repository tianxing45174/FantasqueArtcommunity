package com.fantasque.fanmall.auth.feign;

import com.fantasque.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LaFantasque
 * @version 1.0
 */
@FeignClient("fanmall-third-party")
public interface ThirdPartFeignService {

    @GetMapping(value = "/sms/sendCode")
    R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);

    @GetMapping(value = "/sms/sendQQmailCode")
    R sendQQmailCode(@RequestParam("mail") String mail, @RequestParam("code") String code);

}

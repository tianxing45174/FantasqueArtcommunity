package com.fantasque.fanmall.thirdparty.controller;

import com.fantasque.common.utils.R;
import com.fantasque.fanmall.thirdparty.util.QQMailUtils;
import com.fantasque.fanmall.thirdparty.util.SmsMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/sms")
public class MsgSendController {

    @Autowired
    SmsMsgUtils smsMsgUtils;
    @Autowired
    QQMailUtils qqMailUtils;

    /**
     * 提供给别的服务进行调用
     * @param phone
     * @param code
     * @return
     */
    @GetMapping(value = "/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        //发送验证码
        smsMsgUtils.sendSms(phone, code);

        return R.ok();
    }

    /**
     * 提供给别的服务进行调用
     * @param mail
     * @param code
     * @return
     */
    @GetMapping(value = "/sendQQmailCode")
    public R sendQQmailCode(@RequestParam("mail") String mail, @RequestParam("code") String code) {
        //发送验证码
        qqMailUtils.sendMail(mail, code);

        return R.ok();
    }

}
package com.fantasque.fanmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fantasque.common.utils.PageUtils;
import com.fantasque.fanmall.member.entity.MemberEntity;
import com.fantasque.fanmall.member.exception.PhoneException;
import com.fantasque.fanmall.member.exception.UsernameException;
import com.fantasque.fanmall.member.vo.MemberUserLoginVo;
import com.fantasque.fanmall.member.vo.MemberUserRegisterVo;
import com.fantasque.fanmall.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author tianxing
 * @email tianxing@gmail.com
 * @date 2023-04-30 15:08:55
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 用户注册
     * @param vo
     */
    void register(MemberUserRegisterVo vo);

    /**
     * 判断邮箱是否重复
     * @param phone
     * @return
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     * @param userName
     * @return
     */
    void checkUserNameUnique(String userName) throws UsernameException;

    /**
     * 用户登录
     * @param vo
     * @return
     */
    MemberEntity login(MemberUserLoginVo vo);

    /**
     * 社交用户的登录
     * @param socialUser
     * @return
     */
    MemberEntity login(SocialUser socialUser) throws Exception;

    /**
     * 微信登录
     * @param accessTokenInfo
     * @return
     */
    MemberEntity login(String accessTokenInfo);
}


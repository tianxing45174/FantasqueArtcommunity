package com.fantasque.fanmall.thirdparty.util;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Data
@Component
public class QQMailUtils {

    @Value("${spring.mail.username}")
    private String from;
    @Value("${spring.mail.host}")
    //设置发送邮件的主机  smtp.qq.com 用来设置服务器地址，主机名 。。 可以省略
    private String host;
    @Value("${spring.mail.password}")
    private String password;

    //发送验证码邮件
    public void sendMail(String to, String code){

        //1.创建连接对象，连接到邮箱服务器
        Properties props = System.getProperties();

        //设置邮件服务器
        props.setProperty("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        //SSL加密
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

        sf.setTrustAllHosts(true);

        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        //props：用来设置服务器地址，主机名；Authenticator：认证信息
        Session session = Session.getDefaultInstance(props,new Authenticator() {

            @Override

            //通过密码认证信息

            protected PasswordAuthentication getPasswordAuthentication() {

                //new PasswordAuthentication(用户名, password);
                //这个用户名密码就可以登录到邮箱服务器了,用它给别人发送邮件
                return new PasswordAuthentication(from,password);

            }

        });
        try {

            Message message = new MimeMessage(session);

            //2.1设置发件人：
            message.setFrom(new InternetAddress(from));

            //2.2设置收件人 这个TO就是收件人
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //2.3邮件的主题
            message.setSubject("来自在线视频播放平台网站验证码邮件");

            //2.4设置邮件的正文 第一个参数是邮件的正文内容 第二个参数是：是文本还是html的连接
            message.setContent("<h1>来自在线视频播放平台网站验证码邮件,请接收你的验证码：</h1><h3>你的验证码是：<b style=\"color: red\">"+code+"</b>，请妥善保管好你的验证码！</h3>", "text/html;charset=UTF-8");

            //3.发送一封激活邮件
            Transport.send(message);

        }catch(MessagingException mex){
            mex.printStackTrace();
        }
    }
}

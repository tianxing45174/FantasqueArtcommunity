package com.fantasque.artcommunity.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fantasque.artcommunity.config.AliyunOssConfig;
import com.fantasque.artcommunity.entity.User;
import com.fantasque.artcommunity.mapper.UserMapper;
import com.fantasque.artcommunity.service.ArtworkService;
import com.fantasque.artcommunity.service.UserService;
import com.fantasque.artcommunity.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArtworkService artworkService;

    private static String salt = "fantasque";

    @GetMapping("/show/{id}")
    public String showuser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "test";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model, HttpServletResponse res) {
        user.setNickname(user.getUsername());
        List<User> users = userService.list();
        for (User u : users) {
            if (user.getUsername().equals(u.getUsername()) && u.getStatus().equals("1")) {
                model.addAttribute("username", user.getUsername());
                model.addAttribute("password-one", user.getPassword());
                model.addAttribute("password", user.getPassword());
                model.addAttribute("errmsg", "用户名已存在");
                return "register";
            }
        }

        user.setPassword(new Md5Hash(user.getPassword(), salt, 1024).toHex());

        boolean b = userService.save(user);
        this.createUserCookie(user, res, 1);
        return "redirect:/user/toIndex";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpServletResponse res) {
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            System.out.println("Subject subject = SecurityUtils.getSubject()==" + SecurityUtils.getSubject());

            Subject subject = SecurityUtils.getSubject();

            subject.login(new UsernamePasswordToken(username, password));
        } catch (UnavailableSecurityManagerException e) {
//            System.out.println("UnavailableSecurityManagerException");
            e.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException e){
//            System.out.println("IncorrectCredentialsException");
            model.addAttribute("username", username);
            model.addAttribute("loginmsg", "密码错误");
            e.printStackTrace();
            return "login";
        } catch (UnknownAccountException e){
//            System.out.println("UnknownAccountException");
            model.addAttribute("username", username);
            model.addAttribute("loginmsg", "用户名不存在");
            e.printStackTrace();
            return "login";
        } catch (AuthenticationException e){
//            System.out.println("AuthenticationException");
            model.addAttribute("username", username);
            model.addAttribute("loginmsg", "权限不足，无法访问");
            e.printStackTrace();
            return "login";
        } catch (Exception e){
//            System.out.println("Exception");
            model.addAttribute("username", username);
            e.printStackTrace();
            return "login";
        }
//        List<User> users = userService.list();
//        for (User u : users) {
//            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                this.createUserCookie(userService.findByUserName(username), res, 1);
//                return "redirect:/user/toIndex";
//            }
//        }
        return "redirect:/user/toIndex";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute User user, HttpServletResponse res) {

        this.createUserCookie(user, res, 0);

        return "redirect:/user/toIndex";
    }

    @PostMapping("/toUploadUser")
    public String toUploadUser(HttpServletRequest res, Model model) {
        model.addAttribute("user", userService.getUserIdByCookie(res));
        return "/view/usersettings";
    }

    @PostMapping("/uploadUser")
    public String uploadUser(
            @RequestParam("profilePhoto") MultipartFile profilePhoto,
            @RequestParam("username") String username,
            @RequestParam("id") Integer userid,
            @RequestParam("nickname") String nickname,
            @RequestParam("userComment") String userComment,
            @RequestParam("sex") String sex,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("birthday") String birthday,
            HttpServletRequest req,
            Model model) {

        String filepath = null;
        User user = new User(userid, username, null, nickname, userComment, sex, email, address, birthday, filepath, null);
        //判断是否上传文件
        if (!profilePhoto.isEmpty()) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AliyunOssConfig.class);
            AliyunOssConfig appConfig = context.getBean(AliyunOssConfig.class);

            String accessId = appConfig.getAccessId();
            String accessKey = appConfig.getAccessKey();
            String endpoint = appConfig.getEndpoint();
            String bucket = appConfig.getBucket();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String fileName = UUID.randomUUID().toString() + profilePhoto.getOriginalFilename();
            String host = "https://" + bucket + "." + endpoint;
            String dir = "artcommunity/profile_photo/" + username + "/";
            System.out.println("fileName" + fileName);
            String key = dir + fileName;

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
            try {
                ossClient.putObject(bucket, key, profilePhoto.getInputStream());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                model.addAttribute("errmsg", "上传失败，请重新上传");
                return "view/error";
            }
            ossClient.shutdown();

            filepath = host + "/" + key;

            user.setProfilePhoto(filepath);
        }

        if (userService.updateById(user)) {
            return "redirect:/user/toIndex";
        } else {
            model.addAttribute("errmsg", "上传失败，请重新上传");
            return "view/error";
        }


    }

    @PostMapping("/toUploadUsernameAndPassword")
    public String toUploadUsernameAndPassword(HttpServletRequest res, Model model) {
        model.addAttribute("user", userService.getUserIdByCookie(res));
        return "/view/passwordandusernamesetting";
    }

    @PostMapping("/uploadUsernameAndPassword")
    public String uploadUsernameAndPassword(@ModelAttribute User user,
                                            @RequestParam("password-one") String passwordone,
                                            @RequestParam("password-two") String passwordtwo,
                                            HttpServletResponse res,
                                            HttpServletRequest req,
                                            Model model) {
        List<User> users = userService.list();
        for (User u : users) {
            if (user.getUsername().equals(u.getUsername()) && !user.getId().equals(u.getId()) && u.getStatus().equals("1")) {
                model.addAttribute("username", user.getUsername());
                model.addAttribute("password-one", user.getPassword());
                model.addAttribute("password-two", user.getPassword());
                model.addAttribute("errmsg", "用户名已存在");
                return "/view/passwordandusernamesetting";
            } else if (user.getId().equals(u.getId()) && !(passwordone.equals(u.getPassword()))) {
                model.addAttribute("username", user.getUsername());
                model.addAttribute("password-one", user.getPassword());
                model.addAttribute("password-two", user.getPassword());
                model.addAttribute("errmsg", "旧密码错误");
                return "/view/passwordandusernamesetting";
            }
            if (user.getId().equals(u.getId()) && passwordone.equals(u.getPassword())) {
                User changeUser = new User();
                changeUser.setId(user.getId());
                changeUser.setUsername(user.getUsername());
                changeUser.setPassword(passwordtwo);
                userService.updateById(changeUser);
                this.createUserCookie(user, res, 0);
                return "redirect:/jsp/login.jsp";
            }
        }
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password-one", user.getPassword());
        model.addAttribute("password-two", user.getPassword());
        model.addAttribute("errmsg", "用户不存在数据，请重新登录");
        return "redirect:/user/toIndex";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute User user, HttpServletResponse res) {

        userService.removeById(user.getId());

        this.createUserCookie(user, res, 0);

        return "redirect:/user/toIndex";
    }

    @GetMapping("/toIndex")
    public String toIndex(HttpServletRequest req, Model model) {
        artworkService.modelGetArtworkPage(artworkService.getAllPageToCurrPage(1), model);
        try {
            model.addAttribute("user", userService.getUserIdByCookie(req));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return "index";
    }

    @RequestMapping("/toMyDetails")
    public String toMyDetails(HttpServletRequest req, Model model) {
        User user = userService.getUserIdByCookie(req);

        artworkService.modelGetArtworkPage(artworkService.getPageById(user.getId()), model);

        model.addAttribute("user", user);
        return "view/user";
    }

    @GetMapping("/getUser")
    @ResponseBody
    private R getUser(HttpServletRequest req) {
        User user = null;
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("userid")) {
                user = userService.getById(cookies[i].getValue());
                return R.ok().put("user", user);
            }
        }
        return R.error("用户不存在");
    }

    @PostMapping("/toArtworkUser")
    private String toArtworkUser(@ModelAttribute User user, Model model) {
        System.out.println("user==" + user);
        User artworkUser = userService.getById(user.getId());

        artworkService.modelGetArtworkPage(artworkService.getPageById(artworkUser.getId()), model);

        model.addAttribute("artworkuser", artworkUser);

        return "/view/artworkuser";
    }

    @GetMapping("/getPage/{currPage}")
    public Page<User> getPage(@PathVariable("currPage") int currPage) {
        Page<User> page = new Page<>(currPage, 16);
        Page<User> userPage = userMapper.selectPage(page, null);

        System.out.println("当前页：" + userPage.getCurrent());
        System.out.println("每页显示的条数：" + userPage.getSize());
        System.out.println("总记录数：" + userPage.getTotal());
        System.out.println("总页数：" + userPage.getPages());
        System.out.println("是否有上一页：" + userPage.hasPrevious());
        System.out.println("是否有下一页：" + userPage.hasNext());

        return userPage;
    }

    /**
     * 管理UserCookie
     *
     * @param user
     * @param res
     * @param age  age为 0 时销毁Cookie
     */
    private void createUserCookie(User user, HttpServletResponse res, Integer age) {
        int MaxAge = 30 * 24 * 60 * 60;
        if (age == 0) {
            MaxAge = age;
        }
//        System.out.println("MaxAgeMaxAgeMaxAgeMaxAgeMaxAge" + MaxAge);
        //创建id cookie
        Cookie useridCookie = new Cookie("userid", user.getId() + "");
        useridCookie.setMaxAge(MaxAge);
        useridCookie.setPath("/");
        res.addCookie(useridCookie);
        //创建username cookie
        Cookie usernameCookie = new Cookie("username", user.getUsername() + "");
        usernameCookie.setMaxAge(MaxAge);
        usernameCookie.setPath("/");
        res.addCookie(usernameCookie);
    }
}

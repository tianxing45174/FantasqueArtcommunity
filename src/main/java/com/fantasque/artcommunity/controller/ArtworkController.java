package com.fantasque.artcommunity.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fantasque.artcommunity.config.AliyunOssConfig;
import com.fantasque.artcommunity.entity.Artwork;
import com.fantasque.artcommunity.entity.User;
import com.fantasque.artcommunity.mapper.ArtworkMapper;
import com.fantasque.artcommunity.service.ArtworkService;
import com.fantasque.artcommunity.service.UserService;
import com.fantasque.artcommunity.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Controller
@RequestMapping("/artwork")
public class ArtworkController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArtworkService artworkService;

    @Autowired
    private ArtworkMapper artworkMapper;

    /**
     * 获取指定作者的作品
     *
     * @param userid
     * @return
     */
    @GetMapping("/getPage/{userid}")
    @ResponseBody
    public R getPage(@PathVariable("userid") int userid) {
        Page<Artwork> page = artworkService.getPageById(userid);
        return R.ok().put("page", page);
    }

    /**
     * 获取所有作品分页信息
     *
     * @param currPage 当前页数
     * @param model
     * @return
     */
    @PostMapping("/getArtworkAllPage/{currPage}")
    public String getArtworkAllPage(@PathVariable("currPage") int currPage, Model model) {

        artworkService.modelGetArtworkPage(artworkService.getAllPageToCurrPage(currPage), model);

        return "index";
    }

    /**
     * 无跳转刷新页面
     * @param currPage 请求页
     * @return
     */
//    @GetMapping("/getArtworkAllPage/{currPage}")
//    @ResponseBody
//    public R getArtworkAllPage(@PathVariable("currPage") int currPage) {
//        return R.ok().put("page",artworkService.getAllPageToCurrPage(currPage));
//    }

    /**
     * 获取作品详细
     *
     * @param artworkId 获取的作品id
     * @param req
     * @param model
     * @return
     */
    @PostMapping("/artworkByArtworkId/{artworkId}")
    public String artworkByArtworkId(@PathVariable("artworkId") String artworkId, HttpServletRequest req, Model model) {

        Artwork artwork = artworkService.getById(artworkId);

        artworkService.modelGetArtworkPage(artworkService.getPageById(artwork.getUserid()), model);

        model.addAttribute("artworkuser", userService.getById(artwork.getUserid()));
        model.addAttribute("artwork", artwork);
        model.addAttribute("user", userService.getUserIdByCookie(req));

        return "/view/artwork";
    }

    @PostMapping("/uploadUser")
    public String uploadUser(
            @RequestParam("artworkaddress") MultipartFile artworkFile,
            @RequestParam("artworktitle") String artworktitle,
            @RequestParam("artworkcomment") String artworkcomment,
            HttpServletRequest req,
            Model model) {
        User user = userService.getUserIdByCookie(req);

        String filepath = null;
        if (!artworkFile.isEmpty()) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AliyunOssConfig.class);
            AliyunOssConfig appConfig = context.getBean(AliyunOssConfig.class);

            String accessId = appConfig.getAccessId();
            String accessKey = appConfig.getAccessKey();
            String endpoint = appConfig.getEndpoint();
            String bucket = appConfig.getBucket();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String fileName = UUID.randomUUID().toString() + artworkFile.getOriginalFilename();
            String host = "https://" + bucket + "." + endpoint;
            String dir = "artcommunity/artwork/" + user.getUsername() + "/";
            String key = dir + fileName;

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);
            try {
                ossClient.putObject(bucket, key, artworkFile.getInputStream());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            ossClient.shutdown();

            filepath = host + "/" + key;

        }
        Artwork artwork = new Artwork(null, user.getId(), artworktitle, artworkcomment, filepath);

        if (artworkService.save(artwork)) {
            return "forward:/artwork/artworkByArtworkId/" + artwork.getArtworkid();
        } else {
            model.addAttribute("errmsg", "上传失败，请重新上传");
            return "view/error";
        }

    }

}

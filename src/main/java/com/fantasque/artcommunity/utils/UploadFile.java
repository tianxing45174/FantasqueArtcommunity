package com.fantasque.artcommunity.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.fantasque.artcommunity.config.AliyunOssConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LaFantasque
 * @version 1.0
 */

/**
 * 对象存储数据存在src/main/resources/aliyunoss.properties中
 * alicloud.access-key=accessId
 * alicloud.secret-key=accessKey
 * alicloud.oss.endpoint=endpoint
 * alicloud.oss.bucket=bucket
 */


public class UploadFile {

    public static void main(String[] args) throws Exception {
        R r = new UploadFile().testUpload();
        System.out.println(r);
    }



    public R testUpload() throws FileNotFoundException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AliyunOssConfig.class);
        AliyunOssConfig appConfig = context.getBean(AliyunOssConfig.class);

        String accessId = appConfig.getAccessId();
        String accessKey = appConfig.getAccessKey();
        String endpoint = appConfig.getEndpoint();
        String bucket = appConfig.getBucket();

        // 填写Host地址，格式为https://bucketname.endpoint。
        String host = "https://" + bucket + "." + endpoint;
        // 设置上传回调URL，即回调服务器地址，用于处理应用服务器与OSS之间的通信。OSS会在文件上传完成后，把文件上传信息通过此回调URL发送给应用服务器。
//        String callbackUrl = "https://192.168.0.0:8888";
        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
//        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = "artcommunity/profile_photo/" + "username" + "/";
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String fileName = "null.png";
        String filePath= "F:\\code\\"+fileName;
        FileInputStream fileInputStream = new FileInputStream((filePath));

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessId, accessKey);

        Map<String, String> respMap = null;
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            // respMap.put("expire", formatISO8601Date(expiration));
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("accessid= "+respMap.get("accessid"));
            System.out.println("policy= "+respMap.get("policy"));
            System.out.println("signature= "+respMap.get("signature"));
            System.out.println("dir= "+respMap.get("dir"));
            System.out.println("host= "+respMap.get("host"));
            System.out.println("expire= "+respMap.get("expire"));
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("key= "+respMap.get("dir")+respMap.get("signature")+fileName);
            String key = respMap.get("dir")+respMap.get("signature")+fileName;
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            ossClient.putObject(bucket, key, fileInputStream);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("result= "+ respMap.get("host") +"/"+key);

//https://gulimall-fantasque.oss-cn-guangzhou.aliyuncs.com/artcommunity/profile_photo/username/PdxaRuPzCXWlvW5Jr7+P+Q5eztQ=null.png
//https://gulimall-fantasque.oss-cn-guangzhou.aliyuncs.com/artcommunity/profile_photo/username/PdxaRuPzCXWlvW5Jr7%2BP%2BQ5eztQ%3Dnull.png
        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            System.out.println(e.getMessage());
        }
        return R.ok().put("data", respMap);

    }

}

package com.fantasque.fanmall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanmallThirdPartyApplicationTests {

	@Resource
	OSSClient ossClient;

	@Test
	public void testUpload() throws FileNotFoundException {

//        String endpoint = "oss-cn-guangzhou.aliyuncs.com";
//        //AccessKey有所有API访问权限，使用RAM子账号进行API访问
//        String accessKeyId = "LTAI5tJga7LLK5NU9KCC2YMT";
//        String accessKeySecret = "mhyQUFbiwcpLsaWPA647KSkymX6FIp";
//
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		InputStream inputStream = new FileInputStream("C:\\Users\\tianx\\Desktop\\ttttest.png");

		ossClient.putObject("fanmall-fantasque","test5.png",inputStream);

		ossClient.shutdown();
		System.out.println("上传成功");
	}

}

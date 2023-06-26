package com.fantasque.artcommunity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author LaFantasque
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:aliyunoss.properties")
public class AliyunOssConfig {

    @Value("${alicloud.access-key}")
    private String accessId;

    @Value("${alicloud.secret-key}")
    private String accessKey;

    @Value("${alicloud.oss.endpoint}")
    private String endpoint;

    @Value("${alicloud.oss.bucket}")
    private String bucket;

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}

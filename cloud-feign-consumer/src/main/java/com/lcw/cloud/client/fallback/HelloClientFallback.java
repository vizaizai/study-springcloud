package com.lcw.cloud.client.fallback;

import com.lcw.cloud.client.HelloClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/12 14:56
 */
@Component
public class HelloClientFallback implements HelloClient {
    @Override
    public String hello() {
        return "fallback:hello()";
    }

    @Override
    public String upload(MultipartFile file) {
        return "fallback:upload()";
    }
}

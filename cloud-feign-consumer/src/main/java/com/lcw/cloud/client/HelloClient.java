package com.lcw.cloud.client;

import com.lcw.cloud.client.fallback.HelloClientFallback;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author liaochongwei666@163.com
 * @date 2019/9/12 10:40
 */
@FeignClient(value = "eureka-provider",
        fallback = HelloClientFallback.class,
        configuration = HelloClient.MultipartSupportConfig.class)
public interface HelloClient {

    @GetMapping("/hello")
    String hello();


    /*
      1. @RequestPart: 这儿一定要用@RequestPart @RequestParam会报错,
      2. consumes = MediaType.MULTIPART_FORM_DATA_VALUE必须加上
     */
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);


    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}

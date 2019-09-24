package com.lcw.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:17
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${eureka.instance.instance-id}")
    private String instance;

    @GetMapping("/hello")
    public String hello(@RequestHeader String token) {
        String services = "Services: " + discoveryClient.getServices()+ " instance:"+instance + " token" + token;
        System.out.println(services );
        return services;
    }
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return file.getOriginalFilename();
    }
}

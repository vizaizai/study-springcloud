package com.lcw.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:17
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello() {
        String services = "Services: " + discoveryClient.getServices()+ " instance:"+applicationName + port;
        System.out.println(services);
        return services;
    }
}

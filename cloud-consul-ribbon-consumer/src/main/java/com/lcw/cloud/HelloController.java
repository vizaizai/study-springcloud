package com.lcw.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:40
 */
@RestController
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("RibbonConsumerApplication");
        return restTemplate.getForObject("http://consul-provider/hello", String.class);
    }
}

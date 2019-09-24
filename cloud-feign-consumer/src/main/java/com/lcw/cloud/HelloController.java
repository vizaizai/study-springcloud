package com.lcw.cloud;

import com.lcw.cloud.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:40
 */
@RestController
public class HelloController {


    @Autowired
    private HelloClient helloClient;
    @Autowired
    private SayHelloSender sayHelloSender;

    @GetMapping("/hello")
    public String hello(String msg) {
       sayHelloSender.sendMsg(msg);
       return helloClient.hello();
    }

    @PostMapping("/upload")
    String upload(@RequestParam("file") MultipartFile file){
        return helloClient.upload(file);
    }
}


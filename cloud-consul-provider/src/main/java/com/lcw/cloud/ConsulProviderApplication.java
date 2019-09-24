package com.lcw.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulProviderApplication.class).web(true).run(args);
    }
}

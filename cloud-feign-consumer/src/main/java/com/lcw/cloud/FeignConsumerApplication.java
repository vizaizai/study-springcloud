package com.lcw.cloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/11 15:39
 */
//@EnableCircuitBreaker // 启动断路器  @SpringCloudApplication
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignConsumerApplication.class).web(true).run(args);
    }

}

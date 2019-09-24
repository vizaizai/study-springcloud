package com.lcw.cloud;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/24 10:08
 */
public interface SayHelloInput {
    String INPUT = "say-hello";

    @Input(SayHelloInput.INPUT)
    SubscribableChannel input();
}

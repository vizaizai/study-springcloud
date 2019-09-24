package com.lcw.cloud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/24 10:08
 */
public interface SayHelloOutput {
    String OUTPUT = "say-hello";

    @Output(SayHelloOutput.OUTPUT)
    MessageChannel output();
}

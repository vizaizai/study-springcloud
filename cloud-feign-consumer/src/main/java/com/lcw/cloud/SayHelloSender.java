package com.lcw.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/24 10:08
 */
@EnableBinding(value = {SayHelloOutput.class})
public class SayHelloSender {
    @Autowired
    private SayHelloOutput sayHelloOutput;

    public void sendMsg(String msg) {
        sayHelloOutput.output().send(MessageBuilder.withPayload("hello:" + msg).build());
    }

}

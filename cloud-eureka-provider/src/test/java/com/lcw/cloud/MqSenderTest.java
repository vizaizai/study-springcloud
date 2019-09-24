package com.lcw.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/23 17:43
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = {MqSenderTest.SinkSender.class})
public class MqSenderTest {



    @Autowired
    private SinkSender sinkSender;

    @Test
    public void sinkSenderTester() {
        sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
    }

    public interface SinkSender {

        String OUTPUT = "hello-topic";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();

    }
}

package com.lcw.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author liaochongwei666@163.com
 * @date 2019/9/24 9:54
 */
@EnableBinding(SayHelloInput.class)
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(SayHelloInput.INPUT)
    public void receive(String payload) {
        logger.info("Received: {}",payload);
    }
}

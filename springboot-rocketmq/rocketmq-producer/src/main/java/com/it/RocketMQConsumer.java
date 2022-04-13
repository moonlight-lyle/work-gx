package com.it;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "group1", topic = "springboot-mq")
public class RocketMQConsumer implements RocketMQListener {

    @Override
    public void onMessage(Object message) {
        System.out.println("Received message : " + message);
    }
}

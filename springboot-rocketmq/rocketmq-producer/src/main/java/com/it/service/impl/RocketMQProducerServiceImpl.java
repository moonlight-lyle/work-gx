package com.it.service.impl;

import com.it.service.RocketMQProducerService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liuxing
 * @className RocketMQProducerServiceImpl
 * @description 发送消息服务实现
 * @create 2022/4/14/014 21:13
 **/
@Component
public class RocketMQProducerServiceImpl implements RocketMQProducerService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String topic, Message<String> message) {
        rocketMQTemplate.syncSend(topic, message);
    }
}

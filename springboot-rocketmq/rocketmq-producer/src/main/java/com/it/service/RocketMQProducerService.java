package com.it.service;

import org.springframework.messaging.Message;

/**
 * @author liuxing
 * @className RocketMQProducerService
 * @description 发送MQ消息服务
 * @create 2022/4/14/014 21:11
 **/
public interface RocketMQProducerService {

    void sendMessage(String topic, Message<String> message);
}

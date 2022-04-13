package com.it;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/RocketMQ")
public class RocketMQController {

    private final String topic = "springboot-mq";

    @Resource
    private RocketMQProducer producer;

    @RequestMapping("/sendMessage")
    public String sendMessage(String message) {
        producer.sendMessage(topic, message);
        return "消息已发送";
    }

}

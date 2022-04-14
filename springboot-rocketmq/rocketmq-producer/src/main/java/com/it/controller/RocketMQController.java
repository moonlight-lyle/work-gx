package com.it.controller;


import com.alibaba.fastjson.JSONObject;
import com.it.pojo.AdmittedCustomerMqVO;
import com.it.service.RocketMQProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/RocketMQ")
public class RocketMQController {

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @Value("${rocketmq.producer.tags}")
    private String tags;

    @Resource
    private RocketMQProducerService producerService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        // 模拟实际对象数据
        AdmittedCustomerMqVO admittedCustomerMqVO = new AdmittedCustomerMqVO();
        admittedCustomerMqVO.setAdmittedCustomerId(123L);
        admittedCustomerMqVO.setCustomerCode("18089527");
        admittedCustomerMqVO.setCustomerName("中国银行");
        Message<String> message = MessageBuilder.withPayload(JSONObject.toJSONString(admittedCustomerMqVO))
                .setHeader("KEYS", admittedCustomerMqVO.getAdmittedCustomerId().toString())
                .build();
        producerService.sendMessage(topic + ":" + tags, message);
        return "消息已发送";
    }

}

package com.it.mqConsumer;

import com.it.pojo.AdmittedCustomerMqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(
        consumerGroup = "${rocketmq.consumer.group}",
        topic = "${rocketmq.consumer.topic}",
        selectorType = SelectorType.TAG,
        messageModel = MessageModel.CLUSTERING,
        consumeMode = ConsumeMode.ORDERLY
        )
public class Consumer implements RocketMQListener<AdmittedCustomerMqVO> {

    @Override
    public void onMessage(AdmittedCustomerMqVO admittedCustomerMqVO) {
        System.out.println("=============开始消费消息==================");
        log.info("Receive message：{}"+admittedCustomerMqVO);
    }
}
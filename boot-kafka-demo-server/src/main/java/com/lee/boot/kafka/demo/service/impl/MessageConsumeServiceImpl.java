package com.lee.boot.kafka.demo.service.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author heng.li
 * @Date 2019/5/28 13
 * @Description:
 **/
@Component
public class MessageConsumeServiceImpl  {
    @KafkaListener(topics = "test")
    public void consumeMessage(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("message consume！！！！");
        //判断是否NULL
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            //获取消息
            Object message = kafkaMessage.get();

            System.out.println("Receive： +++++++++++++++ Topic:" + topic);
            System.out.println("Receive： +++++++++++++++ Record:" + record);
            System.out.println("Receive： +++++++++++++++ Message:" + message);
        }
    }
}
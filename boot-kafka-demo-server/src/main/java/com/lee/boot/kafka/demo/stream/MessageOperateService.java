package com.lee.boot.kafka.demo.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MessageOperateService {


    @Resource(name = MessageChannelService.TEST_OUTPUT)
    MessageChannel messageChannel;


    public void sendMessage(String message){
        boolean okokokokokoo = messageChannel.send(MessageBuilder.withPayload(message).build());
        System.out.println(okokokokokoo);
        if (okokokokokoo) {
            System.out.println("successsssssssssss");
        }
    }

    @StreamListener(value=MessageChannelService.TEST_INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println(message.getHeaders().toString());
        System.out.println(message.getPayload());
        System.out.println("receive success");
    }
}

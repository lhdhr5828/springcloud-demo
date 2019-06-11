package com.lee.boot.kafka.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lee.boot.kafka.demo.entity.Message;
import com.lee.boot.kafka.demo.service.MessageSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author heng.li
 * @Date 2019/5/28 13
 * @Description:
 **/
@Component
public class MessageSendServiceImpl implements MessageSendService {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Override
    public void sendMessage() {
//        Map map = new HashMap(16);
//        map.put(KafkaHeaders.TOPIC, "test");
//        map.put(KafkaHeaders.PARTITION_ID, 0);
//        GenericMessage message = new GenericMessage("use Message to send message", new MessageHeaders(map));
//        template.send(message);
        ListenableFuture<SendResult<String, Object>> demo = template.send("test", "000000000000000");
        demo.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("message fail!!!!!!!!!!");
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                System.out.println("message success!!!!!!!!!!");
                System.out.println("-------------------------------------------------------------------------");
            }
        });
    }
}

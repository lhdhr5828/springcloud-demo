package com.lee.boot.kafka.demo.controller;

import com.lee.boot.kafka.demo.service.MessageSendService;
import com.lee.boot.kafka.demo.stream.MessageOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "message")
public class MessageController {
    @Autowired
    MessageSendService messageSendService;

    @Autowired
    MessageOperateService messageOperateService;

    @RequestMapping(value = "kafka")
    public String sendMessage(String mes){
//        for (int i = 0; i < 16383; i++) {
            messageSendService.sendMessage(mes);
//        }
        return "sad";
    }
    @RequestMapping(value = "stream")
    public String sendMessageStream(String mes){
        messageOperateService.sendMessage(mes);
        return "happy";
    }

}

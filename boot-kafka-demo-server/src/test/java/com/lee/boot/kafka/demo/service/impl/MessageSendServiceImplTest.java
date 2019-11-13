package com.lee.boot.kafka.demo.service.impl;

import com.lee.boot.kafka.demo.service.MessageSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author heng.li
 * @Date 2019/5/28 13
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSendServiceImplTest {
    @Autowired
    private MessageSendService sendService;

    @Test
    public void sendMessage() {
        sendService.sendMessage("message");
    }
}
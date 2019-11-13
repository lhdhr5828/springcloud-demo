package com.lee.boot.kafka.demo.service.impl;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author edz
 */
@Component
public class MessageCallbackHandle {

    public String failMessage(Throwable throwable) {
        return "fail";
    }

    public String successMessage(SendResult<String, Object> stringObjectSendResult) {
        return "success";
    }
}

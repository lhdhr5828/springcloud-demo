package com.lee.boot.kafka.demo.stream;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;


public interface MessageChannelService {
    String TEST_OUTPUT = "test_output";
    String TEST_INPUT = "test_input";

    @Output(TEST_OUTPUT)
    MessageChannel outMessage();

    @Input(TEST_INPUT)
    SubscribableChannel receiveMessage();
}

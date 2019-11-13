package com.lee.boot.kafka.demo;


import com.lee.boot.kafka.demo.stream.MessageChannelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.stream.annotation.EnableBinding;


/**
 * @Author heng.li
 * @Date 2019/5/16 13
 * @Description:
 **/

@SpringBootApplication
@EnableBinding(MessageChannelService.class)
public class KafkaDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoServerApplication.class);
    }

}

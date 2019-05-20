package com.lee.cloud.node2.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author heng.li
 * @Date 2019/5/14 11
 * @Description:
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Node2ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Node2ConsumerApplication.class);
    }
}

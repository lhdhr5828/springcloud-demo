package com.lee.cloud.consul.producer.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author heng.li
 * @Date 2019/5/14 11
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducerSecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProducerSecondApplication.class);
    }
}

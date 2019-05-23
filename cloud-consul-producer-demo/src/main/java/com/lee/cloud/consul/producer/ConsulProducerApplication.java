package com.lee.cloud.consul.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author heng.li
 * @Date 2019/5/14 11
 * @Description:
 **/
@SpringBootApplication

public class ConsulProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProducerApplication.class);
    }
}

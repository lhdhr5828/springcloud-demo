package com.lee.producer.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author heng.li
 * @Date 2019/5/15 17
 * @Description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class SecondProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondProducerApplication.class, args);
    }
}

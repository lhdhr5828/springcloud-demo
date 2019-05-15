package com.lee.cloud.server.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author heng.li
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSecondApplication.class, args);
    }

}

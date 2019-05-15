package com.lee.cloud.server.third.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author heng.li
 */
@EnableEurekaServer
@SpringBootApplication
public class ThirdServerApplication {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(Application.class).web(WebApplicationType.NONE).run(args);
        SpringApplication.run(ThirdServerApplication.class, args);
    }

}

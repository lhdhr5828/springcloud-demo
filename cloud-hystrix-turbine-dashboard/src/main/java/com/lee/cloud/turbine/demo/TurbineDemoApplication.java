package com.lee.cloud.turbine.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author heng.li
 * @Date 2019/5/16 13
 * @Description: Finchley版本的cloud使用@EnableHystrix这个注解
 **/
@EnableTurbine
@EnableHystrix
@SpringBootApplication
public class TurbineDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineDemoApplication.class);
    }
}

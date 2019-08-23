package com.lee.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heng.li
 */
@SpringBootApplication(scanBasePackages = {"com.lee.springboot.demo.controller","com.lee.springboot.demo.converter"})
public class SpringbootDeamApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDeamApplication.class);
    }
}

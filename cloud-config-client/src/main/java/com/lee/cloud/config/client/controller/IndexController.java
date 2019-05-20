package com.lee.cloud.config.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heng.li
 * @Date 2019/5/14 17
 * @Description: 使用RefreshScope注解的类会在接到SpringCloud配置中心配置刷新的时候，
 * 自动将新的配置更新到该类对应的字段中。
 **/
@RestController
@RefreshScope
public class IndexController {


    @Value(value = "${neo.hello}")
    private String hello;

    @RequestMapping(value = "/index")
    public String index() {
        return "this is config client";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return hello;
    }
}

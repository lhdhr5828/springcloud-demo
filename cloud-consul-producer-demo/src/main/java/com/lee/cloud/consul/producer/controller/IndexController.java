package com.lee.cloud.consul.producer.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heng.li
 * @Date 2019/5/15 17
 * @Description:
 **/
@RestController
public class IndexController {
    @RequestMapping(value = "/test")
    public String index() {
        return "this is consul producer project";
    }
}

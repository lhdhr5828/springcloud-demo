package com.lee.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heng.li
 * @Date 2019/5/15 17
 * @Description:
 **/
@RestController
public class IndexController {
    @RequestMapping(value = "/hi")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is first messge";
    }
}

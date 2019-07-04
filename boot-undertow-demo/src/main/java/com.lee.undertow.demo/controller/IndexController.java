package com.lee.undertow.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author li.heng
 * @Date 2019/7/4 13
 * @Description:
 **/
@RestController
public class IndexController {
    @RequestMapping(value = "index")
    public String index() {
        return "aaaa";
    }
}

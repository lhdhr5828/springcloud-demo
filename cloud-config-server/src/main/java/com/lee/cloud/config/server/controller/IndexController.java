package com.lee.cloud.config.server.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heng.li
 * @Date 2019/5/14 17
 * @Description:
 **/
@RestController

public class IndexController {

    @RequestMapping(value = "/index")
    public String index() {
        return "this is config server";
    }

}

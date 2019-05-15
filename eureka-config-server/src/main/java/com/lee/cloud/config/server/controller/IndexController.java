package com.lee.cloud.config.server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author heng.li
 * @Date 2019/5/14 17
 * @Description:
 **/
@Controller
public class IndexController {

    @RequestMapping(value = "/test")
    public String a() {
        return null;
    }

}

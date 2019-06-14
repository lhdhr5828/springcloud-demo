package com.lee.boot.shiro.demo.controller;

import com.lee.boot.shiro.demo.entity.User;
import com.lee.boot.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/6/13 15
 * @Description:
 **/
@RestController
@RequestMapping(value = "/visitor")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "Here you are";
    }
    @RequestMapping(value = "/login")
    public String login(String username, String password) {
        return "login success " + username + ":" + password;
    }

    @RequestMapping(value = "/user/get")
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/login/fail")
    public String loginFail() {
        return "login fail";
    }

    @RequestMapping(value = "/permission/error")
    public String noAuth() {
        return "no auth";
    }
}

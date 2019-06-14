package com.lee.boot.shiro.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author li.heng
 * @Date 2019/6/13 16
 * @Description:
 **/
@RestController
@RequestMapping(value = "/auth")
public class AuthController {


    @RequestMapping(value = "/getMessage")
    public String getMessage() {
        return "您拥有用户权限，可以获得该接口的信息！";
    }

    @RequestMapping(value = "/user/get")
    public String getUsers() {
        return "users!!";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, String> map) {
        System.out.println("user login .....");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        return "login !!";
    }


    @RequestMapping(value = "/user/getAll")
    public String getAll(String username, String password) {
        System.out.println("user login .....");
        System.out.println(username);
        System.out.println(password);
        return "you have permission !!";
    }


    @RequestMapping(value = "/success")
    public String success() {
        return "aha here you are success";
    }
}

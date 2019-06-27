package com.lee.boot.shiro.demo.controller;

import com.lee.boot.shiro.demo.entity.User;
import com.lee.boot.shiro.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/6/13 16
 * @Description:
 **/
@Controller
@RequestMapping(value = "/auth")
public class AuthController {


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/user/get")
    public String getUsers(Model model) {
        List<User> allUser = userService.getAllUser();

        model.addAttribute("users", allUser);
        return "user/user-manager";
    }

    @RequestMapping(value = "/user/add/page")
    public String addUser() {
        return "user/user-add";
    }

    @RequestMapping(value = "/user/add")
    public String addUser(String name, String password, Model model) {
        userService.insertUser(name, password);
        model.addAttribute("msg", "添加用户成功");
        return "user/user-add";
    }

    @RequestMapping(value = "/user/update")
    public String updateUser() {
        return "user-update";
    }




    @RequestMapping(value = "/user/getAll")
    public String getAll(String username, String password) {
        String login = "user login .....";
        System.out.println(login);
        System.out.println(username);
        System.out.println(password);
        return "you have permission !!";
    }


    @RequestMapping(value = "/success")
    public String success() {
        return "aha here you are success";
    }
}

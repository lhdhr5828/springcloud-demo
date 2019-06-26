package com.lee.boot.shiro.demo.controller;

import com.lee.boot.shiro.demo.entity.User;
import com.lee.boot.shiro.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/index")
    public String getMessage() {
        return "index";
    }

    @RequestMapping(value = "/user/get")
    public String getUsers(Model model) {
        List<User> allUser = userService.getAllUser();

        model.addAttribute("users", allUser);
        return "user-manager";
    }

    @RequestMapping(value = "/user/add")
    public String addUser(String name, String password, Model model) {
        userService.insertUser(name, password);
        model.addAttribute("msg", "添加用户成功");
        return "user-add";
    }

    @RequestMapping(value = "/user/update")
    public String updateUser() {
        return "user-update";
    }

    @RequestMapping(value = "/login")
    public String login(String username, String password, Model model) {
        System.out.printf("username:%s,password:%s%n", username, password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            System.out.println(e.getMessage());
            model.addAttribute("msg", "用户名未知");
            return "login";
        } catch (IncorrectCredentialsException i) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "index";
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

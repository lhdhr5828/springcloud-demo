package com.lee.boot.shiro.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Map;

/**
 * @Author li.heng
 * @Date 2019/6/13 16
 * @Description:
 **/
@Controller
@RequestMapping(value = "/auth")
public class AuthController {


    @RequestMapping(value = "/index")
    public String getMessage() {
        return "index";
    }

    @RequestMapping(value = "/user/get")
    public String getUsers() {
        return "users!!";
    }
    @RequestMapping(value = "/add")
    public String addUser(){
        return "user-add";
    }
 @RequestMapping(value = "/update")
    public String updateUser(){
        return "user-update";
    }

    @RequestMapping(value = "/login")
    public String login(String username, String password, Model model) {
        System.out.printf("username:%s,password:%s%n", username, password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try{
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
            System.out.println(e.getMessage());
            model.addAttribute("msg","用户名未知");
            return "login";
        }
        catch (IncorrectCredentialsException i) {
            model.addAttribute("msg","密码错误");
            return "login";
        }

        model.addAttribute("username",username);
        model.addAttribute("password",password);
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

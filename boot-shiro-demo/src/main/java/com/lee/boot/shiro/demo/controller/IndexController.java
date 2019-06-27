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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/6/13 15
 * @Description:
 **/
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/login/page")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(String username, String password, Model model) {
        System.out.printf("username:%s,password:%s%n", username, password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            if (savedRequest != null) {
                String requestURI = savedRequest.getRequestURI();
                System.out.println(requestURI);
                System.out.println(savedRequest.getRequestUrl());
                return "redirect:" + requestURI;
            }
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

    @RequestMapping(value = "/")
    public String getMessage() {
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("mes", "已经退出");
        return "index";
    }

    @RequestMapping(value = "/permission/error")
    @ResponseBody
    public String noPermission() {
        return "you have not permission !";
    }
//
//    @RequestMapping(value = "/user/get")
//    @ResponseBody
//    public List<User> getUsers(int i) {
//        System.out.println(i);
//        return userService.getAllUser();
//    }

    @RequestMapping(value = "/login/fail")
    public String loginFail() {
        return "login fail";
    }

}

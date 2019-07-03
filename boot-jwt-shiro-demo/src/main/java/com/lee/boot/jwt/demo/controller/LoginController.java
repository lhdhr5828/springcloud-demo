package com.lee.boot.jwt.demo.controller;

import com.lee.boot.jwt.demo.common.BaseResponse;
import com.lee.boot.jwt.demo.config.JwtUtils;
import com.lee.boot.jwt.demo.entity.User;
import com.lee.boot.jwt.demo.service.UserService;
import com.lee.boot.jwt.demo.util.DigestUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author li.heng
 * @Date 2019/7/2 11
 * @Description:
 **/
@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public BaseResponse login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String password) {
        User user = userService.selectByName(name);
        String salt = user.getSalt();
        String encodePassword = DigestUtils.getInstance().MD5(password, name + salt);
        if (user.getPassword().equals(encodePassword)) {
            return new BaseResponse<>(true, "登录成功", JwtUtils.sign(name, encodePassword));
        } else {
            throw new UnauthorizedException("密码不对哦，亲");
        }
    }

    @RequestMapping(value = "401")
    public String error() {
        return "this is 401";
    }
}

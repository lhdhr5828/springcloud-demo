package com.lee.boot.jwt.demo.controller;

import com.lee.boot.jwt.demo.common.BaseResponse;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author li.heng
 * @Date 2019/7/2 15
 * @Description:
 **/
@RestController
public class OperatorController {

    @RequestMapping(value = "/do")
    @RequiresRoles("user")
    public BaseResponse doSomething(String str) {
        System.out.println(str);
        return new BaseResponse(true, "there is dongmei Ma ", null);
    }

    @RequestMapping(value = "/di")
    @RequiresRoles("user")
    public String doother() {
        return "就他妈你叫夏洛啊？";
    }
}

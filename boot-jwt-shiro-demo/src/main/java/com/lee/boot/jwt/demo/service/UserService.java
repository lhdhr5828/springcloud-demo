package com.lee.boot.jwt.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.boot.jwt.demo.entity.User;

/**
 * @Author li.heng
 * @Date 2019/7/2 11
 * @Description:
 **/
public interface UserService extends IService<User> {


    User selectByName(String name);
}


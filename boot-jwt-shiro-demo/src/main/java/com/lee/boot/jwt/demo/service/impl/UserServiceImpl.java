package com.lee.boot.jwt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.boot.jwt.demo.dao.UserMapper;
import com.lee.boot.jwt.demo.entity.User;
import com.lee.boot.jwt.demo.service.UserService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author li.heng
 * @Date 2019/7/2 11
 * @Description:
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByName(String name) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", name));
        if (user == null) {
            throw new UnknownAccountException("用户名为：" + name + " 的用户未找到！");
        }
        return user;
    }
}

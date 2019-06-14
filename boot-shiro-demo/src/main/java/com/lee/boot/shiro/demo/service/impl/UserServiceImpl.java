package com.lee.boot.shiro.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.boot.shiro.demo.dao.PermissionMapper;
import com.lee.boot.shiro.demo.dao.RoleMapper;
import com.lee.boot.shiro.demo.dao.UserMapper;
import com.lee.boot.shiro.demo.entity.Role;
import com.lee.boot.shiro.demo.entity.User;
import com.lee.boot.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/6/13 09
 * @Description:
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User getUserByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("name", username);
        User user = userMapper.selectOne(wrapper);
        return user;
    }


    @Override
    public List<Role> getRole(String username) {
        User user = this.getUserByName(username);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<Role>().eq("user_id", user.getId());
        List<Role> roles = roleMapper.selectList(queryWrapper);
        return roles;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        return users;
    }
}

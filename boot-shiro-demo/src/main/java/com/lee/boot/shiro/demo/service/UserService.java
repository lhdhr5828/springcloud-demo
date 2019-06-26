package com.lee.boot.shiro.demo.service;

import com.lee.boot.shiro.demo.dao.UserMapper;
import com.lee.boot.shiro.demo.entity.Role;
import com.lee.boot.shiro.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/6/13 09
 * @Description:
 **/

public interface UserService {

    List<User> getAllUser();

    User getUserByName(String username);

    List<Role> getRole(String username);

    void insertUser(String name, String password);

    void updateUser(Integer id, String name, String password);
}

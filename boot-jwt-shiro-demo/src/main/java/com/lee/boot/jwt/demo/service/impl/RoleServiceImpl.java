package com.lee.boot.jwt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.boot.jwt.demo.entity.Role;
import com.lee.boot.jwt.demo.dao.RoleMapper;
import com.lee.boot.jwt.demo.service.RoleService;

/**
 * @Author li.heng
 * @Date 2019/7/2 11
 * @Description:
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role selectByUserId(Integer userId) {
        return roleMapper.selectOne(Wrappers.lambdaQuery(new Role()).eq(Role::getUserId, userId));
    }
}

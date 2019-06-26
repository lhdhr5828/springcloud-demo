package com.lee.boot.shiro.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.boot.shiro.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
package com.lee.boot.jwt.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.boot.jwt.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
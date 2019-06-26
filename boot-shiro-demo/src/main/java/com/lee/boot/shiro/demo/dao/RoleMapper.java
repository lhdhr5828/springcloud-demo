package com.lee.boot.shiro.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.boot.shiro.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
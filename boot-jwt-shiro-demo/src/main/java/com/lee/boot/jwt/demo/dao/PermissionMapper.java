package com.lee.boot.jwt.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.boot.jwt.demo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
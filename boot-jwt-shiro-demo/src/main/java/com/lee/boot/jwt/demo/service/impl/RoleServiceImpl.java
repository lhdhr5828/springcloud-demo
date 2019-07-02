package com.lee.boot.jwt.demo.service.impl;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

}

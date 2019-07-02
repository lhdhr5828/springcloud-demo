package com.lee.boot.jwt.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.boot.jwt.demo.dao.PermissionMapper;
import com.lee.boot.jwt.demo.entity.Permission;
import com.lee.boot.jwt.demo.service.PermissionService;
/**
 * @Author li.heng
 * @Date 2019/7/2 11
 * @Description:
 **/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService{

}

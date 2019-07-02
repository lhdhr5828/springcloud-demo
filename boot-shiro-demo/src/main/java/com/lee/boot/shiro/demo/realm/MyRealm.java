package com.lee.boot.shiro.demo.realm;

import com.lee.boot.shiro.demo.entity.Role;
import com.lee.boot.shiro.demo.entity.User;
import com.lee.boot.shiro.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author li.heng
 * @Date 2019/6/12 11
 * @Description:
 **/
public class MyRealm extends AuthorizingRealm {

    public MyRealm() {
        System.out.println("初始化");
    }

    @Autowired
    private UserService userService;

    /**
     * 权限认证
     * 验证身份已认证的用户的权限和角色
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");

        Subject subject = SecurityUtils.getSubject();
        // 这里就是SimpleAuthenticationInfo实例化时的Principal
        User user = (User) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获得该用户角色
        List<Role> roles = userService.getRole(user.getName());
        Set<String> set = new HashSet<>();
        // 需要将 role 封装到 Set 作为 info.setRoles() 的参数
        for (Role role : roles) {
            set.add(role.getRoleName());
        }
        // 设置该用户的角色
        info.setRoles(set);
        // 设置权限字符串
        info.setStringPermissions(new HashSet<>());
        return info;
    }

    /**
     * 身份认证
     * 验证数据库用户名和密码
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        User user = userService.getUserByName(token.getUsername());

        if (null == user) {
            return null;
        }
        //
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}

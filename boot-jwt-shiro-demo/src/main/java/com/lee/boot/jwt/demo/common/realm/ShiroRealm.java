package com.lee.boot.jwt.demo.common.realm;

import com.lee.boot.jwt.demo.common.JWTToken;
import com.lee.boot.jwt.demo.config.JwtUtils;
import com.lee.boot.jwt.demo.entity.Role;
import com.lee.boot.jwt.demo.entity.User;
import com.lee.boot.jwt.demo.service.RoleService;
import com.lee.boot.jwt.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/7/2 17
 * @Description:
 **/
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 权限认证
     * 验证身份已认证的用户的权限和角色
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = JwtUtils.getUsername(principalCollection.toString());
        User user = userService.selectByName(name);
        Role role = roleService.selectByUserId(user.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(role.getRoleName());
        return simpleAuthorizationInfo;
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        String username = JwtUtils.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        User user = userService.selectByName(username);
        if (user == null) {
            throw new AuthenticationException("user not found");
        }

        if (JwtUtils.verify(token, username, user.getPassword())) {
            return new SimpleAuthenticationInfo(token, token, "my_realm");
        }
        throw new AuthenticationException("authentication error");
    }
}

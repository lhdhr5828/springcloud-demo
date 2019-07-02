package com.lee.boot.jwt.demo.common;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author li.heng
 * @Date 2019/7/2 17
 * @Description:
 **/
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

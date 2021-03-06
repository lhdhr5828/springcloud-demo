package com.lee.boot.shiro.demo.config;

import com.lee.boot.shiro.demo.realm.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


/**
 * @Author li.heng
 * @Date 2019/6/12 17
 * @Description:
 **/
@Configuration
public class ShiroConfig {
    @Bean
    public SecurityManager securityManager(@Autowired MyRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setSessionManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactory(SecurityManager securityManager) {
        System.out.println("初始化shiro的过滤器！！！！");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/index/login/page");
        // 无权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/index/permission/error");

//        登录成功后的跳转
//        shiroFilterFactoryBean.setSuccessUrl("/auth/success");

        // 设置拦截器
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>(16);
        // anon无需验证
        filterMap.put("/index/*", "anon");
        // 无参，需要认证
        filterMap.put("/auth/*", "authc");
//        filterMap.put("/auth/*/*", "authc");
//        filterMap.put("/auth/*", "authc");

        // 无参，注销，执行后会直接跳转到shiroFilterFactoryBean.setLoginUrl()
        filterMap.put("/index/logout", "logout");

        // authcBasic，无参，表示httpBasic认证
//        filterMap.put("/eee", "authcBasic");

        // 表示必须存在用户
//        filterMap.put("/user/*", "user");

        // 表示请求必须为https安全请求
//        filterMap.put("/aa", "ssl");
        // 参数可写多个，表示需要具有某个权限才可通过
        filterMap.put("/auth/user/*", "roles[user]");
        filterMap.put("/auth/user/*/*", "roles[user]");

        // 参数可写多个，表示需要某些角色才可通过
//        filterMap.put("/ccc", "roles[\"admin，user\"]");

        // perms 资源授权
//        filterMap.put("/auth/add","perms[user:add]");
//        filterMap.put("/**", "perms");
        //anon authc roles users 等都在DefaultFilter中被定义，当加载shiro时会自动置为可用
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public MyRealm getMyRealm() {
        return new MyRealm();
    }
}

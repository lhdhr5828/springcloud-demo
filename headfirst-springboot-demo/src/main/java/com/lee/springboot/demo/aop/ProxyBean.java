package com.lee.springboot.demo.aop;


import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @Author li.heng
 * @Date 2019/7/12 11
 * @Description:
 **/
public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;


    public static Object getProxy(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;

        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        boolean isException = false;
        Invocation invocation = new Invocation(target, method, args);
        Object returnObject = null;

        try {
            if (this.interceptor.before()) {
                returnObject = this.interceptor.round(invocation);
            } else {
                returnObject = method.invoke(target, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
            isException = true;
        }
        this.interceptor.after();
        if (isException) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return returnObject;
        }
        return null;
    }
}

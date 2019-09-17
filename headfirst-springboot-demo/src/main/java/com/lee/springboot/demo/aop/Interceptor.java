package com.lee.springboot.demo.aop;


import java.lang.reflect.InvocationTargetException;

/**
 * @Author li.heng
 * @Date 2019/7/12 10
 * @Description:
 **/
public interface Interceptor {
    boolean before();
    void after();
    Object round(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    void afterReturning();
    void afterThrowing();
    boolean useAround();
}

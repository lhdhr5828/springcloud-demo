package com.lee.springboot.demo.aop;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author li.heng
 * @Date 2019/7/12 11
 * @Description:
 **/
public class MyInterceptor implements Interceptor {


    @Override
    public boolean before() {
        System.out.println("method before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("method after");
    }

    @Override
    public Object round(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around ing ing ing ing ing");
        Object proceed = invocation.proceed();
        System.out.println("around ed ed ed ed ed ");
        return proceed;
    }

    @Override
    public void afterReturning() {
        System.out.println("after method return");
    }

    @Override
    public void afterThrowing() {
        System.out.println("throw exception ed ed ed ed");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}

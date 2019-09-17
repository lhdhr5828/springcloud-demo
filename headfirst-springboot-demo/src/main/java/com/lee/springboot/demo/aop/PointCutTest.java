package com.lee.springboot.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class PointCutTest implements Ordered {

    /**
     * 表达式匹配切点
     */
    @Pointcut(value = "execution(* com.lee.springboot.demo.aop.*(..))")
    public void pointCut() {

    }


    /**
     * 注解切点
     */
    @Pointcut(value = "@annotation(com.lee.springboot.demo.aop.PointCCut)")
    public void annotationPointCut() {

    }

    /**
     * ioc容器中的bean切点
     */
    @Pointcut(value = "bean(servletConfig)")
    public void beanPointCut() {

    }

    @Before(value = "annotationPointCut()&&args(name)")
    public void before(String name) {
        System.out.println("before");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturn() {
        System.out.println("after return");
    }


    @Around(value = "pointCut()&&args(name)")
    public void around(ProceedingJoinPoint point, String name) throws Throwable {
        Object proceed = point.proceed();
    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        System.out.println("after throwing");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

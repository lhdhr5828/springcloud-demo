package com.lee.springboot.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author li.heng
 * @Date 2019/7/11 11
 * @Description:
 **/
@Component
public class Student implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Override
    public void play() {
        System.out.println("play");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("set bean name ing!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("set beanFactory ing!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("set application");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after set properties");
    }

    @PreDestroy
    public void aDestroy() {
        System.out.println("annotation destroy");
    }

    @PostConstruct
    public void init() {
        System.out.println("annotation init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy!!!!");
    }
}

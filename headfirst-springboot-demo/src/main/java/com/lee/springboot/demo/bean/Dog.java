package com.lee.springboot.demo.bean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/7/11 10
 * @Description:
 **/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("dog run");
    }

    @Override
    public void play(Person person) {
        System.out.println("play with " + person.getClass().getName());
    }
}

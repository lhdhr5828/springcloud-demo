package com.lee.springboot.demo.bean;

import com.lee.springboot.demo.ioc.CatConditionConfig;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/7/11 11
 * @Description:
 **/
@Component
@Scope("prototype")
@Conditional(value = CatConditionConfig.class)
public class Cat implements Animal {
    @Override
    public void run() {

    }

    @Override
    public void play(Person person) {

    }
}

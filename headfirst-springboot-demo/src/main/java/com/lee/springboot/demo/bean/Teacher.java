package com.lee.springboot.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/7/11 11
 * @Description:
 **/
@Component
public class Teacher implements Person {


    /**
     * Qualifier注解用来在同一类型的bean有多个时，指定bean的name
     * 因为Autowired注解只有一个是否必须注入的选项
     */
    @Autowired
//    @Qualifier(value = "dog")
    private Animal animal;

    @Override
    public void play() {
        animal.play(this);
    }
}

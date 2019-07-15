package com.lee.springboot.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/7/11 10
 * @Description: @Component注解注入时的beanname默认是类名首字母小写，不如这里就是doctor，
 * 所以在使用@Service注入service时，beanname为实现类名的首字母小写
 **/
@Component
public class Doctor implements Person {

    /**
     * @Value 注解可以给bean注入默认值，该值也可以从配置文件中获取，使用${key}的方式
     */
    @Value(value = "贾克斯")
    private String name;


    @Value(value = "12")
    private Integer age;


    @Override
    public void play() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

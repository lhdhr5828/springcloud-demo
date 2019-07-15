package com.lee.springboot.demo.ioc;

import com.lee.springboot.demo.bean.Animal;
import com.lee.springboot.demo.bean.Cat;
import com.lee.springboot.demo.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author li.heng
 * @Date 2019/7/11 10
 * @Description:
 **/
@Configuration
public class DepBean {


    /**
     * 如果不指定name，会使用方法名作为bean的name
     *
     * @return
     */
    @Bean(name = "animal")
    public Animal animal() {

        Cat cat = new Cat();
        return cat;
    }
}

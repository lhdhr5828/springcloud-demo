package com.lee.springboot.demo.aop;

/**
 * @Author li.heng
 * @Date 2019/7/12 10
 * @Description:
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null) {
            throw new RuntimeException("12");
        }
        System.out.println("hello " + name);
    }
}

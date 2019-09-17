package com.lee.springboot.demo.aop;

/**
 * @Author li.heng
 * @Date 2019/7/12 11
 * @Description:
 **/
public class Test {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxy(helloService, new MyInterceptor());
        proxy.sayHello("lee");
        proxy.sayHello(null);
    }
}

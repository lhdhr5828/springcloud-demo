package com.lee.springboot.demo.ioc;

import com.lee.springboot.demo.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author li.heng
 * @Date 2019/7/11 10
 * @Description:
 **/
public class BeanFactoryDemo {
    public static void main(String[] args) {
//        getBeanByBeanAnnotation();
//        getBeanByComponent();
//        doSomethingByDependency();
//        beanLife();
//        conditionCatTest();
    }


    private static void getBeanByBeanAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        Dog animalByName =  applicationContext.getBean(Dog.class);
        Dog bean = applicationContext.getBean(Dog.class);
//        Animal bean = applicationContext.getBean(Dog.class);
//        单例，打印为true
        System.out.println(animalByName == bean);
    }

    private static void getBeanByComponent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        Person bean = applicationContext.getBean(Person.class);
        Person doctor = (Person) applicationContext.getBean("doctor");
        System.out.println(bean == doctor);
    }

    private static void doSomethingByDependency() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        teacher.play();
    }


    private static void beanLife() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        Student bean = applicationContext.getBean(Student.class);
        ((AnnotationConfigApplicationContext) applicationContext).close();
        System.out.println(bean.toString());
    }

    private static void conditionCatTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        Cat bean = applicationContext.getBean(Cat.class);
        System.out.println(bean.toString());
    }
}

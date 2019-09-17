package com.lee.springboot.demo.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * @Author li.heng
 * @Date 2019/7/11 10
 * @Description: ComponentScan注解默认扫描当前包下的类和当前包的子包中的类
 * excludeFilters可以添加扫描过滤条件，参数类型是Filter注解
 **/
@ComponentScan(value = "com.lee.springboot.demo.bean", lazyInit = false,
        excludeFilters= @ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION))
public class ComponentScanBean {


}

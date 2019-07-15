package com.lee.springboot.demo.ioc;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author li.heng
 * @Date 2019/7/11 16
 * @Description:
 **/
public class CatConditionConfig implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        boolean aaa = environment.containsProperty("animal");
        return aaa;
    }
}

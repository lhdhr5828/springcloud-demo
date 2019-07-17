package com.lee.springboot.demo.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Tesst {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate bean = applicationContext.getBean(RedisTemplate.class);
        bean.opsForValue().set("key1", "value1");
        Object key2 = bean.opsForValue().get("key2");
        System.out.println(key2);
    }
}

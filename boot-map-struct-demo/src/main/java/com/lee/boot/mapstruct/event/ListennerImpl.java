package com.lee.boot.mapstruct.event;

import com.lee.boot.mapstruct.uitil.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: Lee
 * @Date: 2019/9/17 0017 23:28
 * @Description:
 */
@Component
public class ListennerImpl implements ApplicationListener {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        redisUtils.set("ListennerImpl","2");
    }
}

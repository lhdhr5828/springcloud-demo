package com.lee.boot.mapstruct.event;

import com.lee.boot.mapstruct.uitil.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Lee
 * @Date: 2019/9/17 0017 23:26
 * @Description:
 */
@Component
public class RunnerImpl implements ApplicationRunner {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisUtils.set("RunnerImpl","3");
    }
}

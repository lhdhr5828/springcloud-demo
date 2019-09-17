package com.lee.boot.mapstruct.event;

import com.lee.boot.mapstruct.config.RedisConfig;
import com.lee.boot.mapstruct.uitil.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Lee
 * @Date: 2019/9/17 0017 23:27
 * @Description:
 */
@Component
public class ComandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public void run(String... args) throws Exception {
        redisUtils.set("ComandLineRunnerImpl","1");
    }
}

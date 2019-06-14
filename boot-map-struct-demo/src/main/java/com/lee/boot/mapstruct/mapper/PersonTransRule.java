package com.lee.boot.mapstruct.mapper;

import org.springframework.stereotype.Component;

/**
 * @Author li.heng
 * @Date 2019/6/6 15
 * @Description:
 **/
@Component
public class PersonTransRule {
    public boolean intToBoolean(int age) {
        return age > 18;
    }
}

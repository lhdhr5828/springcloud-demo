package com.lee.boot.mapstruct.mapper;

/**
 * @Author li.heng
 * @Date 2019/6/6 15
 * @Description:
 **/
public class PersonTransRule {
    public boolean intToBoolean(int age) {
        return age > 18;
    }
}

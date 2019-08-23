package com.lee.springboot.demo.converter;

import com.lee.springboot.demo.bean.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class String2UserConvert implements Converter<String, User> {

    @Override
    public User convert(String source) {
        String[] split = source.split("-");
        User user = new User();
        user.setName(split[0]);
        user.setAge(Integer.parseInt(split[1]));
        return user;
    }
}

package com.lee.springboot.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class PointCutService {

    @PointCCut
    public String test(String age, String name) {

        return "";
    }
}

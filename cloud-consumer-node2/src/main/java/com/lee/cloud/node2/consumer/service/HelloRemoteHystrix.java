package com.lee.cloud.node2.consumer.service;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author heng.li
 * @Date 2019/5/16 11
 * @Description:
 **/
@Component
public class HelloRemoteHystrix implements IndexService {

    @Override
    public String index(@RequestParam(value = "name") String name) {
        return "hello" + name + ", this message send failed ";
    }
}

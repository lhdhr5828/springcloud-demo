package com.lee.cloud.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author heng.li
 * @Date 2019/5/14 17
 * @Description:
 **/

@FeignClient(name = "spring-cloud-producer")
public interface IndexService {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}

package com.lee.cloud.consumer.controller;

import com.lee.cloud.consumer.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heng.li
 * @Date 2019/5/15 17
 * @Description:
 **/
@RestController
public class IndexController {

    @Autowired
    IndexService service;

    @RequestMapping(value = "/hi/{name}")
    public String index(@PathVariable String name) {
        return service.index(name);
    }
}

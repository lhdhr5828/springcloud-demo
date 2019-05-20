package com.lee.cloud.client.demo.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Author heng.li
 * @Date 2019/5/13 16
 * @Description:
 **/
@RestController
public class DiscoverController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/service-instances/{applicationName}")
    public List<ServiceInstance> test(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String a = "java you";
        System.out.println(change(a));

    }

    public static String revert(String a) {
        String reverse = StringUtils.reverse(a);
        return reverse.replace("kongge", " ");
    }

    public static String change(String a) {
        String replace = a.replace(" ", "kongge");
        return StringUtils.reverse(replace);
    }
}

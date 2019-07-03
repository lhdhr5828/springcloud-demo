package com.lee.websocket.demo.controller;

import com.lee.websocket.demo.endpoint.IndexEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author li.heng
 * @Date 2019/7/3 18
 * @Description:
 **/
@RestController
public class IndexController {
    @Autowired
    private IndexEndpoint endpoint;

    @RequestMapping(value = "/index")
    public void index() {
        IndexEndpoint.sendMessage("这里是web请求哦", null);
    }
}

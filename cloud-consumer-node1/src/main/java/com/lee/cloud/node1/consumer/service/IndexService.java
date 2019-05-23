package com.lee.cloud.node1.consumer.service;


import com.lee.cloud.node1.consumer.service.HelloRemoteHystrix;
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

@FeignClient(name = "spring-gateway-producer", fallback = HelloRemoteHystrix.class)
public interface IndexService {

    /**
     * 调用服务提供
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi")
    String index(@RequestParam(value = "name") String name);

}

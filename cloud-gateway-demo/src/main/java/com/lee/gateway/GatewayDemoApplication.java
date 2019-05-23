package com.lee.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


/**
 * @Author heng.li
 * @Date 2019/5/16 13
 * @Description:
 **/

@SpringBootApplication
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class);
    }

    /**
     * 功能与配置中的spring:cloud:gateway:routes: 一样，配置中是定义多个RouteDefinition
     * 这里是在访问项目路径+/about时会将项目路径替换为http://ityouknow.com，
     * 所以实际访问的是http://ityouknow.com/about
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/about")
                        .uri("http://ityouknow.com"))
                .build();
    }
}

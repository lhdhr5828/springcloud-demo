package com.lee.websocket.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author li.heng
 * @Date 2019/7/3 16
 * @Description:
 **/
@Configuration
public class WebSocketConfig {

    /**
     * 开启webSocket的webEndpoint支持
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter getServerEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

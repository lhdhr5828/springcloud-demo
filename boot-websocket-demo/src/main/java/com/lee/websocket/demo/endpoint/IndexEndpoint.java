package com.lee.websocket.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author li.heng
 * @Date 2019/7/3 16
 * @Description: 端口与容器端口相同
 **/
@Component
@ServerEndpoint("/index")
public class IndexEndpoint {


    private Session session;

    private static CopyOnWriteArraySet<IndexEndpoint> set = new CopyOnWriteArraySet();

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        set.add(this);
        System.out.println(set.size());
        System.out.println("有人来了！");
    }

    @OnMessage
    public void onMessage(String str, Session session) {

        System.out.println(str);
        sendMessage("俺收到了");
    }


    @OnClose
    public void onClose() {
        System.out.println("close");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("error");
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

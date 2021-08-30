package com.estufa.estufa.sockets;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value="/controladores")
public class Socket {

    private Session session;
    private static Set<Socket> listen = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println("Cliente OCnectado");
        this.session = session;
        listen.add(this);
    }

    @OnMessage
    public void message(Session session, String message) throws InterruptedException {
        for (int i = 0;i < 10;i++){
            Thread.sleep(500);
            broadcast("1|22");
        }
    }

    public static void broadcast(String message) {
        for (Socket listener : listen) {
            listener.sendMessage(message);
        }
    }

    @OnClose
    public void onClose(Session session){
        listen.remove(this);
    }

    private void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

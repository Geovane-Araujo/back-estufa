package com.estufa.estufa.sockets;

import com.atom.Atom;
import com.estufa.estufa.estufaConnection.EstufaConnections;
import com.estufa.estufa.model.Controladores;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value="/controladores")
public class Socket {

    private Session session;
    EstufaConnections estufaConnections = new EstufaConnections();
    private static Set<Socket> listen = new CopyOnWriteArraySet<>();
    Atom at = new Atom();
    List<Map> controladores = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) throws EncodeException, IOException {
        System.out.println("Cliente Conectado");
        this.session = session;
        Gson gjo = new Gson();
        String json = gjo.toJson(getControlers());
        session.getBasicRemote().sendText(json);
        listen.add(this);
    }

    @OnMessage
    public void message(Session session, String message) throws InterruptedException {
        String b = "";
        while(session.isOpen()){
            String a = "";
            for(Map e: controladores){
                a += e.get("ref") + "|" + randon() + "|"+ randonTemperatura() + "|"+ randonPh() + "|"+ randonCondutividade() + "?";
            }
            Thread.sleep(5000);
            broadcast(a);
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

    private Object getControlers(){
        controladores.clear();
        Hashtable ret = new Hashtable();
        try{
            Connection con = estufaConnections.getNewConnections("estufa_inf");
            String sql = "select controladores.nome || ' - ' || pessoa.nome  || ' - ' || fases_crecimento.descricao as fase, controladores.nome as ref,ph,condutividade \n" +
                    "from controladores\n" +
                    "\tinner join pessoa on pessoa.id = controladores.idestufa\n" +
                    "\tinner join fases_crecimento on controladores.idfase = fases_crecimento.id\n" +
                    "  inner join estufa_setor on estufa_setor.id = controladores.idsetor " +
                    "where ativo = 1";

            controladores = (List<Map>)at.getAll(Map.class,con,sql);

            ret.put("obj",controladores);
            ret.put("ret","success");
            return ret;
        }
        catch (SQLException ex){
            ret.put("ret","unsuccess");
            return ret;
        }
    }
    private String randon(){
        int a =0;
        a = (int)(Math.random() * 100) + 1;
        return String.valueOf(a);
    }
    private String randonPh(){
        int a =0;
        a = (int)(Math.random() * 14) + 1;
        return String.valueOf(a);
    }

    private String randonTemperatura(){
        int a =0;
        Random r = new Random();
        a = r.nextInt((42 - 18) + 1) + 18;
        return String.valueOf(a);
    }

    private String randonCondutividade(){
        double a =0;
        a = (double)(Math.random() * 4) + 1;
        return String.valueOf(a);
    }
}

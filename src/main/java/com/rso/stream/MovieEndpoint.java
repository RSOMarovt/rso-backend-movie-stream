package com.rso.stream;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;

/**
 * Created by urbanmarovt on 12/11/2017.
 */

@ServerEndpoint("/v1/movies/{idMovie}")
public class MovieEndpoint {

    @OnOpen
    public void onConnectionOpen(final Session session, @PathParam("idMovie") final int idMovie) {

        System.out.println("Session opened");
        System.out.println(Integer.toString(idMovie));
    }

    @OnMessage
    public String broadcastMessage(String message) {
        System.out.println("Someone send message!!!");

        return "Aloha1";
    }

    @OnClose
    public void onConnectionClose(Session session) {

    }

}

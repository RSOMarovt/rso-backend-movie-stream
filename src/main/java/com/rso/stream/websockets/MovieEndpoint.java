package com.rso.stream.websockets;

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

@ServerEndpoint("/v1/streamMessaging/{streamId}")
public class MovieEndpoint {

    @OnOpen
    public void onConnectionOpen(final Session session, @PathParam("streamId") final String streamId) {

        System.out.println("Session opened");
        System.out.println(streamId);
    }

    @OnMessage
    public String broadcastMessage(String message) {
        System.out.println("Someone send message!!!");

        return message;
    }

    @OnClose
    public void onConnectionClose(Session session) {

    }

}

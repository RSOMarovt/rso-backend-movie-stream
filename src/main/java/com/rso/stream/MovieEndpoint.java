package com.rso.stream;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by urbanmarovt on 12/11/2017.
 */

@ServerEndpoint("/movie")
public class MovieEndpoint {

    @OnMessage
    public String broadcastMessage(String message) {
        System.out.println("Someone send message!!!");

        return "Aloha";
    }

}

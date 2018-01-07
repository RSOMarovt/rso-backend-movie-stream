package com.rso.stream.models;

/**
 * Created by urbanmarovt on 06/01/2018.
 */
public class Message {
    private String user;
    private String text;

    public Message() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

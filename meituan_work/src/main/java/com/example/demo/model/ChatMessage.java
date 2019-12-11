package com.example.demo.model;

import java.io.Serializable;

/**
 * @Author Mcorleon
 * @Date 2019/12/5 21:04
 */
public class ChatMessage implements Serializable {
    private String from;
    private String to;
    private String content;
    private String type;
    public ChatMessage(String from, String to, String content,String type) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.type=type;
    }

    public  ChatMessage(){

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

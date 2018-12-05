package com.ps.demo.service;

public class Message {
    private String data;
    private SenderType senderType;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SenderType getSenderType() {
        return senderType;
    }

    public void setSenderType(SenderType senderType) {
        this.senderType = senderType;
    }
}

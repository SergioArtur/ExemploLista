package com.example.exemplolista.model;

public class ListItem {
    private String head;
    private String desc;

    // Constructor
    public ListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }
    // Getters
    public String getHead() {
        return head;
    }
    public String getDesc() {
        return desc;
    }
}
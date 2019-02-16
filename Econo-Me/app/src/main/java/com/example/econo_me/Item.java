package com.example.econo_me;

public class Item {
    private String name;
    private String desc;

    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public Item(String name){
        this.name = name;
        this.desc = "";
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

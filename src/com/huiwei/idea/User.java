package com.huiwei.idea;

public class User {

    private String name;
    public User(){};
    public User(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(1/0);
    }
}

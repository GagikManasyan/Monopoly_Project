package com.company;

public class Jail extends Square {
    private String name;

    Jail (String name){
        this.name= name;
    }
    protected String getName(){
        return name;
    }
}

package com.company;

public class Electricity extends Square {
    private String name;
    Electricity(String name){
        this.name= name;

    }
    protected String getName(){
        return name;
    }
}

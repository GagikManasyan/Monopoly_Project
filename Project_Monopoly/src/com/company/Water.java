package com.company;

public class Water extends Square
{
    private String name;
    Water(String name){
        this.name = name;
    }
    protected String getName(){
        return name;
    }
}

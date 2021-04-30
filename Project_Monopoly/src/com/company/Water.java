package com.company;

public class Water extends Square
{
    private String name = "Water";
    private int price;
    protected Water(int price)
    {
        this.price = price;
    }
    protected String getName(){
        return name;
    }


}

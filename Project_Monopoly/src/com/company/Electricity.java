package com.company;

public class Electricity extends Square {
    private String name = "Electricity";
    private int price;
    protected Electricity (int price)
    {
        this.price = price;
    }
    protected String getName()
    {
        return name;
    }
}

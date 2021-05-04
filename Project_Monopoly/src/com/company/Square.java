package com.company;

public class Square
{
    private String name;
    private int price;
    private Player owner;
    private boolean owned = false;
    private int rent_price;
    Square(String name)
    {
        this.name = name;
    }
    Square()
    {

    }
    protected String getName(){
        return name;
    }
    protected Player getOwner()
    {
        return this.owner;
    }
    protected boolean isOwned() {
        return owned;
    }
}

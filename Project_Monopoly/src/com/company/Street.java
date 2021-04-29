package com.company;

public class Street extends Square
{
    private String name;
    private int price;
    private String owner = "no one";
    private boolean owned = false;
    protected Street (String name, int price)
    {
        this.name = name;
        this.price = price;
    }
    protected void AddHotel()
    {

    }
    protected void Own (String player, boolean owned)
    {
        this.owner = player;
        this.owned = owned;

    }
    protected String getName(){
        return name;
    }

    public boolean isOwned() {
        return owned;
    }
    public String getOwner()
    {
        return this.owner;
    }

    public int getPrice() {
        return price;
    }
}

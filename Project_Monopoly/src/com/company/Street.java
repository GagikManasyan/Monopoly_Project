package com.company;

public class Street extends Square
{
    private String name;
    private int price;
    private Player owner;
    private boolean owned = false;
    protected Street (String name, int price)
    {
        this.name = name;
        this.price = price;
    }
    protected void AddHotel()
    {

    }
    protected void Own (Player player, boolean owned)
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
    public Player getOwner()
    {
        return this.owner;
    }

    public int getPrice() {
        return price;
    }
}

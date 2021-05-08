package com.company;

public class Water extends Square
{
    private String name;
    private int price;
    private int rentPrice;
    private Player owner;
    private boolean owned = false;
    protected Water(String name,int price, int rentPrice)
    {
        this.name = name;
        this.price = price;
        this.rentPrice = rentPrice;
    }
    protected String getName(){
        return name;
    }
    protected void Own (Player player, boolean owned)
    {
        this.owner = player;
        this.owned = owned;

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

    public int getRentPrice() {
        return rentPrice;
    }
    protected void Sell ()
    {
        this.owner = null;
        this.owned = false;
    }


}

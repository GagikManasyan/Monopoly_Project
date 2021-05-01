package com.company;

public class Street extends Square
{
    private String name;
    private int price;
    private int rent_price;
    private Player owner;
    private boolean owned = false;
    protected Street (String name, int price, int rent_price)
    {
        this.name = name;
        this.price = price;
        this.rent_price = rent_price;
    }
    protected void AddHotel()
    {

    }
    protected void AddHouse()
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

    protected boolean isOwned() {
        return owned;
    }
    protected Player getOwner()
    {
        return this.owner;
    }

    protected int getPrice() {
        return price;
    }

    protected int getRentPrice() {
        return rent_price;
    }
    protected void doubleRent()
    {
        this.rent_price = 2 * this.rent_price;
    }

}

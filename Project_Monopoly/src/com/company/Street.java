package com.company;

public class Street extends Square
{
    private String name;
    private int price;
    private int rent_price;
    private Player owner;
    private boolean owned = false;
    private boolean set = false;
    protected Street (String name, int price, int rent_price)
    {
        this.name = name;
        this.price = price;
        this.rent_price = rent_price;
    }
    protected void AddHotel(int hotel)
    {

    }
    protected void AddHouse(int house)
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
    protected void isSet (boolean status)
    {
        this.set = status;
    }
    protected Player getOwner()
    {
        return this.owner;
    }

    protected int getPrice() {
        return price;
    }

    protected int getRentPrice()
    {
        if(this.set == true)
        {
            return  2 * this.rent_price;
        }
        return rent_price;
    }


}

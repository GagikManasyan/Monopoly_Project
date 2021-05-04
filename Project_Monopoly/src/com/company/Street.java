package com.company;

public class Street extends Square
{
    private String name;
    private int price;
    private int rent_price;
    private Player owner;
    private boolean owned = false;
    private boolean set = false;
    private static int house_count = 0;
    private int housePrice;
    private int rentwith1house;
    private int rentwith2house;
    private int rentwith3house;
    private int rentwith4house;
    protected Street (String name, int price, int rent_price, int housePrice, int rentwith1house,int rentwith2house,int rentwith3house,int rentwith4house)
    {
        this.name = name;
        this.price = price;
        this.rent_price = rent_price;
        this.housePrice = housePrice;
        this.rentwith1house = rentwith1house;
        this.rentwith2house = rentwith2house;
        this.rentwith3house = rentwith3house;
        this.rentwith4house = rentwith4house;
    }
    protected void AddHotel(int hotel)
    {

    }
    protected void AddHouse(int house)
    {
        house_count += house;
        if(house_count == 1)
        {
            rent_price += rentwith1house;
        }
        if(house_count == 2)
        {
            rent_price += rentwith2house;
        }
        if(house_count == 3)
        {
            rent_price += rentwith3house;
        }
        if(house_count == 4)
        {
            rent_price += rentwith4house;
        }
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
    protected void isSet (boolean status, Player player)
    {
        this.set = status;
        hasSet(player);
    }
    protected boolean getSet ()
    {
        return this.set;
    }
    protected void hasSet (Player player)
    {
        player.isHasSet(true);
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

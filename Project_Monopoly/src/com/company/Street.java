package com.company;


public class Street extends Square
{
    ///Street type
    private String name;
    private int price;
    private int rent_price;
    private Player owner;
    private boolean owned = false;
    private boolean set = false;
    private int house_count = 0;
    private int hotel_count;
    private int housePrice;
    private int hotelPrice;
    private int rentwith1house;
    private int rentwith2house;
    private int rentwith3house;
    private int rentwith4house;
    private int rentwithhotel;
    protected Street (String name, int price, int rent_price, int housePrice, int rentwith1house,int rentwith2house,int rentwith3house,int rentwith4house, int rentwithhotel)
    {
        this.name = name;
        this.price = price;
        this.rent_price = rent_price;
        this.housePrice = housePrice;
        this.hotelPrice = housePrice * 5;
        this.rentwith1house = rentwith1house;
        this.rentwith2house = rentwith2house;
        this.rentwith3house = rentwith3house;
        this.rentwith4house = rentwith4house;
        this.rentwithhotel = rentwithhotel;
    }
    protected void AddHotel(Player player)
    {
        hotel_count = 1;
        rent_price = rentwithhotel;
        house_count = 0;
        player.setHotelcount(1);

    }
    protected void AddHouse(int house, Player player)
    {
        house_count += house;
        if(house_count == 1)
        {
            rent_price = rentwith1house;
            player.setHousecount(1);
        }
        if(house_count == 2)
        {
            rent_price = rentwith2house;
            player.setHousecount(2);
        }
        if(house_count == 3)
        {
            rent_price = rentwith3house;
            player.setHousecount(3);
        }
        if(house_count == 4)
        {
            rent_price = rentwith4house;
            player.setHousecount(4);
        }
    }
    protected void Own (Player player, boolean owned)
    {
        this.owner = player;
        this.owned = owned;

    }
    protected void Sell ()
    {
        this.owner = null;
        this.owned = false;
    }
    protected String getName(){
        return name;
    }

    protected boolean isOwned() {
        return owned;
    }
    protected void isSet (boolean status, Player player)
    {
        if(status == false)
        {
            this.set = status;
        }
        else
        {
            this.set = status;
            hasSet(player);
        }
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
        if(this.set == true && this.house_count == 0 && this.hotel_count == 0)
        {
            return  2 * this.rent_price;
        }
        return rent_price;
    }
    protected int getHouse_count ()
    {
        return this.house_count;
    }
    protected int getHousePrice() {
        return housePrice;
    }
    protected int getHotel_count ()
    {
        return this.hotel_count;
    }
    public int getHotelPrice() {
        return hotelPrice;
    }
}

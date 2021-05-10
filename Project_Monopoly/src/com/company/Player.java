package com.company;

public class Player
{
    ///Player
    private String player_name;
    private boolean outOfJailCard = false;
    private int player_budget;
    protected int position = 0;
    private boolean inJail = false;
    private boolean hasSet = false;
    private int housecount = 0;
    private int hotelcount = 0;
    private int hasTrains = 0;

    protected Player()
    {
        this.player_budget = 1500;
    }
    public void setPlayer_name (String name)
    {
        this.player_name = name;
    }
    protected void giveMoney(int money)
    {
        this.player_budget += money;
    }
    protected void takeMoney(int money)
    {
        this.player_budget -= money;
    }
    protected void goToJail ()
    {
        this.inJail = true;
        this.position = 10;
    }
    protected void FreeJail ()
    {
        this.inJail = false;
    }
    protected void outOfJailCard (boolean status)
    {
        this.outOfJailCard = status;
    }
    protected String getPlayerName ()
    {
        return this.player_name;
    }
    protected int getPlayer_budget()
    {
        return this.player_budget;
    }
    protected int getHasTrains() {
        return hasTrains;
    }
    protected void setHotelcount(int number)
    {
        hotelcount += number;
    }
    protected int getHotelcount()
    {
        return hotelcount;
    }
    protected void setHousecount(int number)
    {
        housecount += number;
    }
    protected int getHousecount()
    {
        return housecount;
    }
    protected boolean isInJail() {
        return inJail;
    }
    protected void isHasSet(boolean hasSet) {
        this.hasSet = hasSet;
    }
    public boolean OutOfJailCard() {
        return outOfJailCard;
    }
    protected void buyTrain()
    {
        hasTrains += 1;
    }

}

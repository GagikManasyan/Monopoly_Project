package com.company;

public class Player
{
    private String player_name;
    private boolean outOfJailCard = false;
    private int player_budget;
    protected int position = 0;
    private boolean inJail = false;
    private boolean hasSet = false;
    private boolean has4Houses = false;
    private int hasTrains = 0;
    protected Player(String name)
    {
        this.player_budget = 1500;
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
    protected String getPlayerName ()
    {
        return this.player_name;
    }
    protected int getPlayer_budget()
    {
        return this.player_budget;
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
    protected boolean bankrupt()
    {
        if(this.player_budget == 0)
        {
            return true;
        }
        return false;
    }

    protected boolean isInJail() {
        return inJail;
    }

    protected void isHasSet(boolean hasSet) {
        this.hasSet = hasSet;
    }
    protected boolean getHasSet() {
        return this.hasSet;
    }
    protected void setHas4Houses (boolean value)
    {
        this.has4Houses = value;
    }

    protected boolean getHas4Houses() {
        return has4Houses;
    }

    public boolean OutOfJailCard() {
        return outOfJailCard;
    }
    protected void buyTrain()
    {
        hasTrains += 1;
    }
    protected int getHasTrains() {
        return hasTrains;
    }
}

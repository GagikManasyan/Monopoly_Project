package com.company;

public class Player
{
    private String player_name;
    private int player_budget;
    protected static int position = 0;
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
    protected boolean bankrupt()
    {
        if(this.player_budget == 0)
        {
            return true;
        }
        return false;
    }
}

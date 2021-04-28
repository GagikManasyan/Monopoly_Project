package com.company;

public class Player
{
    private String player_name;
    private int player_budget;
    Player(String name)
    {
        this.player_budget = 1500;
        this.player_name = name;
    }
    protected void giveMoney(int money)
    {
        this.player_budget += money;
    }
    protected String getPlayerName ()
    {
        return this.player_name;
    }
}

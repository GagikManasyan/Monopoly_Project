package com.company;

public class Chance extends Square
{
    private String name;
    private String [] chance_cards = {"Advance to Go (Collect $200)",
                                      "Advance to Illinois Ave—If you pass Go, collect $200",
                                      "Advance to St. Charles Place – If you pass Go, collect $200",
                                      "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.",
                                      "Advance token to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.",
                                      "Bank pays you dividend of $50",
                                      "Get Out of Jail Free",
                                      "Go Back 3 Spaces",
                                      "Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200",
                                      "Make general repairs on all your property–For each house pay $25–For each hotel $100",
                                      "Pay poor tax of $15","Take a trip to Reading Railroad–If you pass Go, collect $200",
                                      "Take a walk on the Boardwalk–Advance token to Boardwalk",
                                      "You have been elected Chairman of the Board–Pay each player $50",
                                      "Your building and loan matures—Collect $150",
                                      "You have won a crossword competition—Collect $100"};
    protected void action ()
    {

    }
    Chance (String name){
        this.name=name;
    }
    protected String getName(){
        return name;
    }
}

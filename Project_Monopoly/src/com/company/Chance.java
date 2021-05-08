package com.company;
enum ActionType {
    TakeMoney, GiveMoney, Move, Jailcard, MoveToGo, MoveBack, PayForEachHotel;
}
public class Chance extends GameBoard
{
    private String text;
    private ActionType action;
    private int value;
    protected Chance (String text, ActionType action, int value)
    {
        this.text = text;
        this.action = action;
        this.value = value;
    }
    protected void doAction (Player player)
    {
        if(action.equals(ActionType.MoveToGo))
        {
            player.position = value;
            player.giveMoney(200);
        }
        if(action.equals(ActionType.MoveBack))
        {
            player.position = player.position - value;
            if(player.position == 0)
            {
                player.giveMoney(200);
            }
        }
        if(action.equals(ActionType.Move))
        {
            if(player.position < value)
            {
                player.position = value;
                player.giveMoney(200);
            }
            else
            {
                player.position = value;
            }
        }
        if(action.equals(ActionType.TakeMoney))
        {
            player.takeMoney(value);
        }
        if(action.equals(ActionType.GiveMoney))
        {
            player.giveMoney(value);
        }
        if(action.equals(ActionType.Jailcard))
        {
            player.outOfJailCard(true);
        }
        if(action.equals(ActionType.PayForEachHotel))
        {
            player.takeMoney(player.getHousecount() * (value / 4) + player.getHotelcount() * value);
        }
    }

    protected String getText() {
        return text;
    }
    protected ActionType getActionTypet() {
        return action;
    }
}

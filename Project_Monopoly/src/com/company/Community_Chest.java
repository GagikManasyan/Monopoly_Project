package com.company;

public class Community_Chest extends GameBoard {
    ///Chance cards
    private String text;
    private ActionType action;
    private int value;
    protected Community_Chest (String text, ActionType action, int value)
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
        if(action.equals(ActionType.PayForEachHotel))
        {
            player.takeMoney(player.getHousecount() * 40 + player.getHotelcount() * value);
        }
        if(action.equals(ActionType.Jailcard))
        {
            player.outOfJailCard(true);
        }
    }

    protected String getText() {
        return text;
    }
    protected ActionType getActionTypet() {
        return action;
    }
}

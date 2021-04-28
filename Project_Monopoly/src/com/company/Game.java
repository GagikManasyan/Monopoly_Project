package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    private String [] game_board =
            {"|Go|",
            "|Mediterranean Avenue|",
            "|Chest|" ,
            "|Baltic Avenue|",
            "|Tax|",
            "|Train 1|",
            "|Oriental Avenue|",
            "|Chance|",
            "|Vermont Avenue|",
            "|Connecticut Avenue|",
            "|Jail|",
            "|St Charles Place|",
            "|Electric|",
            "|States Avenue|",
            "|Virginia Avenue|",
            "|Train 2|",
            "|St James Place|",
            "|Tennessee Avenue|",
            "|Chest|",
            "|New York Avenue|",
            "|Parking|",
            "|Kentucky Avenue|",
            "|Chance|",
            "|Indiana Avenue|",
            "|Illinois Avenue|",
            "|Train 3|",
            "|Atlantic Avenue|",
            "|Ventnor Avenue|",
            "|Water|",
            "|Marvin Gardens|",
            "|Go To Jail|",
            "|Pacific Avenue|",
            "|North Carolina Avenue|",
            "|Chest|",
            "|Pennsylvania Avenue|",
            "|Train 4|",
            "|Chance|",
            "|Park Place|",
            "|Luxury|",
            "|Boardwalk|"};
    private static Integer [] player_list = {0 , 0 , 0 , 0};
    protected void Print_board ()
    {
        for (int i = 0; i < game_board.length; i++)
        {
            System.out.println(game_board[i]);

        }
    }
    private int diceRoll()
    {
        int dice_roll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return dice_roll;
    }
    private int takeTurns()
    {
        turn = turn + 1;
        if(turn > 3)
        {
            turn = 0;
        }
        return turn;
    }
    protected void Move()
    {
        int dice_roll = diceRoll();
        int turn = takeTurns();
        System.out.println("Player " + turn + " - " + "Current position - " +  + player_list[turn]);
        System.out.println("Dice - " + dice_roll);
        System.out.println();
        int c = game_board.length - player_list[turn];
        player_list[turn] += dice_roll;
        if(player_list[turn] > 39)
        {
            player_list[turn] = 0;
            player_list[turn] += dice_roll - c;

        }
    }
    protected void Feedback()
    {
        System.out.println("Player " + turn + " - " + game_board[player_list[turn]]);
    }
}

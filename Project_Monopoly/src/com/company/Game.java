package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    private String [] game_board = {"|Go|", "|Mediterranean Avenue|", "|Chest|" ,"|Baltic Avenue|", "|Tax|", "|Train 1|",  "|Oriental Avenue|", "|Chance|", "|Vermont Avenue|", "|Connecticut Avenue|","|Jail|","|St Charles Place|","|Electric|","|States Avenue|","|Virginia Avenue|","|Train 2|","|St James Place|","|Tennessee Avenue|","|Chest|","|New York Avenue|","|Parking|", "|Kentucky Avenue|", "|Chance|", "|Indiana Avenue|", "|Illinois Avenue|", "|Train 3|", "|Atlantic Avenue|", "|Ventnor Avenue|", "|Water|","|Marvin Gardens|", "|Go To Jail|","|Pacific Avenue|", "|North Carolina Avenue|", "|Chest|", "|Pennsylvania Avenue|", "|Train 4|", "|Chance|", "|Park Place|", "|Luxury|", "|Boardwalk|"};
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
        if(turn > 4)
        {
            turn = 1;
        }
        return turn;
    }
    protected void Move()
    {
        int dice_roll = diceRoll();
        System.out.println("Dice - " + dice_roll);
        System.out.println();
        int turn = takeTurns();
        int c = game_board.length - player_list[turn-1];
        player_list[turn-1] += dice_roll;
        if(player_list[turn-1] > 39)
        {
            player_list[turn-1] = 0;
            player_list[turn-1] += dice_roll - c;

        }
    }
    protected void Feedback()
    {
        if(turn == 0)
        {
            System.out.println("player 1 you are on" + game_board[player_list[0]]);
            System.out.println("current position - " + player_list[0]);
            System.out.println("player 2 you are on" + game_board[player_list[1]]);
            System.out.println("current position - " + player_list[1]);
            System.out.println("player 3 you are on" + game_board[player_list[2]]);
            System.out.println("current position - " + player_list[2]);
            System.out.println("player 4 you are on" + game_board[player_list[3]]);
            System.out.println("current position - " + player_list[3]);
            System.out.println();
            System.out.println("Player 1 starts");

        }
        if(turn == 1)
        {
            System.out.println("player 1 you are on" + game_board[player_list[0]]);
            System.out.println("current position - " + player_list[0]);
        }
        if(turn == 2)
        {
            System.out.println("player 2 you are on" + game_board[player_list[1]]);
            System.out.println("current position - " + player_list[1]);
        }
        if(turn == 3)
        {
            System.out.println("player 3 you are on" + game_board[player_list[2]]);
            System.out.println("current position - " + player_list[2]);
        }
        if(turn == 4)
        {
            System.out.println("player 4 you are on" + game_board[player_list[3]]);
            System.out.println("current position - " + player_list[3]);
        }
    }
}

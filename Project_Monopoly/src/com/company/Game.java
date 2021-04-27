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
    private static int player_1_pos = 0;
    private static int player_2_pos = 0;
    private static int player_3_pos = 0;
    private static int player_4_pos = 0;
    private Integer [] player_list = {player_1_pos , player_2_pos , player_3_pos , player_4_pos};
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
        int turn = takeTurns();
        /*if(turn == 1)
        {*/
            int c = game_board.length - player_list[turn-1];
            System.out.println("current position - " + player_list[turn-1]);
            System.out.println("dice roll - " + dice_roll);
            player_list[turn-1] += dice_roll;
            if(player_list[turn-1] > 39)
            {
                player_list[turn-1] = 0;
                player_list[turn-1] += dice_roll - c;

            }
        /*}*/
        /*if(turn == 2)
        {
            int c = game_board.length - this.player_2_pos;
            System.out.println("current position - " + this.player_2_pos);
            System.out.println("dice roll - " + dice_roll);
            this.player_2_pos += dice_roll;
            if(this.player_2_pos > 39)
            {
                this.player_2_pos = 0;
                this.player_2_pos += dice_roll - c;

            }
        }
        if(turn == 3)
        {
            int c = game_board.length - this.player_3_pos;
            System.out.println("current position - " + this.player_3_pos);
            System.out.println("dice roll - " + dice_roll);
            this.player_3_pos += dice_roll;
            if(this.player_3_pos > 39)
            {
                this.player_3_pos = 0;
                this.player_3_pos += dice_roll - c;

            }
        }
        if(turn == 4)
        {
            int c = game_board.length - this.player_4_pos;
            System.out.println("current position - " + this.player_4_pos);
            System.out.println("dice roll - " + dice_roll);
            this.player_4_pos += dice_roll;
            if(this.player_4_pos > 39)
            {
                this.player_4_pos = 0;
                this.player_4_pos += dice_roll - c;

            }
        }*/


    }
    protected void Feedback()
    {
        int turn = takeTurns();
        if(turn == 1)
        {
            System.out.println(turn);
            System.out.println("player 1 you are on" + game_board[this.player_1_pos]);
        }
        /*if(turn == 2)
        {
            System.out.println(turn);
            System.out.println("player 2 you are on" + game_board[this.player_2_pos]);
        }
        if(turn == 3)
        {
            System.out.println(turn);
            System.out.println("player 3 you are on" + game_board[this.player_3_pos]);
        }
        if(turn == 4)
        {
            System.out.println(turn);
            System.out.println("player 4 you are on" + game_board[this.player_4_pos]);
        }*/
    }
}

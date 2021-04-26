package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private String [] [] game_board = new String[11][11];
    private String [] top_line = new String[]{"|Parking|", "|Kentucky Avenue|", "|Chance|", "|Indiana Avenue|", "|Illinois Avenue|", "|Train 3|", "|Atlantic Avenue|", "|Ventnor Avenue|", "|Water|","|Marvin Gardens|", "|Go To Jail|"};
    private String [] left_line = new String[]{"", "|New York Avenue|", "|Chest|", "|Tennessee Avenue|", "|St James Place|", "|Train 2|", "|Virginia Avenue|", "|States Avenue|", "|Electric|", "|St Charles Place|"};
    private String [] right_line = new String[]{"", "|Pacific Avenue|", "|North Carolina Avenue|", "|Chest|", "|Pennsylvania Avenue|", "|Train 4|", "|Chance|", "|Park Place|", "|Luxury|", "|Boardwalk|"};
    private String [] bot_line = new String []{"|Jail|", "|Connecticut Avenue|", "|Vermont Avenue|", "|Chance|", "|Oriental Avenue|", "|Train 1|", "|Tax|", "|Baltic Avenue|", "|Chest|", "|Mediterranean Avenue|", "|Go|"};
    protected void Print_board ()
    {
        for (int i = 0; i < game_board.length; i++)
        {
            game_board[0][i] = top_line[i];
        }
        for (int i = 1; i <= 9; i++)
        {
            game_board[i][0] = left_line[i];
        }
        for (int i = 1; i <= 9 ; i++)
        {
            game_board[i][10] = right_line[i];
        }
        for (int i = 0; i < bot_line.length; i++)
        {
            game_board[10][i] = bot_line[i];
        }
        for (int i = 0; i < game_board.length; i++)
        {
            System.out.println();
            for (int j = 0; j < game_board.length; j++)
            {
                System.out.print(game_board[i][j]);

            }

        }
    }
    protected int Dice_roll()
    {
        int dice_roll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return dice_roll;
    }
    protected void Feedback(){}


}

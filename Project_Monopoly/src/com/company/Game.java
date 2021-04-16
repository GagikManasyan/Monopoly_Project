package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private String [] [] game_board = new String[11][11];
    private String [] top_line = new String[]{"|Parking|", "|Teryan 1|", "|Chance|", "|Teryan 2|", "|Teryan 3|", "|Train 3|", "|Pushkin 1|", "|Pushkin 2|", "|Water|","|Pushkin 3|", "|Go To Jail|"};
    private String [] left_line = new String[]{"", "|Amiryan 3|", "|Chest|", "|Amiryan 2|", "|Amiryan 1|", "|Train 2|", "|Saryan 3|", "|Saryan 2|", "|Electric|", "|Saryan 1|"};
    private String [] right_line = new String[]{"", "|Aram 1|", "|Aram 2|", "|Chest|", "|Aram 3|", "|Train 4|", "|Chance|", "|North Avenue 1|", "|Luxury|", "|North Avenue 2|"};
    private String [] bot_line = new String []{"|Jail|", "|Mashtoc 3|", "|Mashtoc 2|", "|Chance|", "|Mashtoc 1|", "|Train 1|", "|Tax|", "|Tumayan 2|", "|Chest|", "|Tumanyan 1|", "|Start|"};
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

package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    Square [] game_board1;
    Game (String player1, String player2, String player3, String player4){
        game_board1[0] = new Square("Go");
        game_board1[1] = new Street("Mediterranean Avenue");
        game_board1[2] = new Community_chest();
        game_board1[3] = new Street("Baltic Avenue");
        game_board1[4] = new Square("Tax");
        game_board1[5] = new Train("Train 1");
        game_board1[6] = new Street("Oriental Avenue");
        game_board1[7] = new Community_chest();
        game_board1[8] = new Street("Vermont Avenue");
        game_board1[9] = new Street("Connecticut Avenue");
        /*game_board1[10] = new Jail("Jail");*/
        game_board1[11] =
        game_board1[12]
        game_board1[13]
        game_board1[14]
        game_board1[15]
        game_board1[16]
        game_board1[17]
        game_board1[18]
        game_board1[19]
        game_board1[20]
        game_board1[21]
        game_board1[22]
        game_board1[23]
        game_board1[24]
        game_board1[25]
        game_board1[26]
        game_board1[27]
        game_board1[28]
        game_board1[29]
        game_board1[30]
        game_board1[31]
        game_board1[32]
        game_board1[33]
        game_board1[34]
        game_board1[35]
        game_board1[36]
        game_board1[37]
        game_board1[38]
        game_board1[39]



    }
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
    private void takeTurns()
    {
        turn = turn + 1;
        if(turn > 4)
        {
            turn = 1;
        }
    }
    protected void Move()
    {
        int dice_roll = diceRoll();
        int c = game_board.length - player_list[turn-1];
        System.out.println("Current position - " + player_list[turn-1]);
        System.out.println("Dice - " + dice_roll);
        player_list[turn-1] += dice_roll;
        System.out.println();
        if(player_list[turn-1] > 39)
        {
            player_list[turn-1] = 0;
            player_list[turn-1] += dice_roll - c;

        }
    }
    protected void Feedback()
    {
        takeTurns();
        System.out.println("Player " + turn + " you are on - " + game_board[player_list[turn-1]]);
    }
}

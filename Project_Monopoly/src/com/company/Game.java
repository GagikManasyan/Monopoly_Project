package com.company;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    Square [] game_board = new Square[40];
    Game (String player1, String player2, String player3, String player4){
        game_board[0] = new Square("Go");
        game_board[1] = new Street("Mediterranean Avenue");
        game_board[2] = new Community_chest();
        game_board[3] = new Street("Baltic Avenue");
        game_board[4] = new Square("Tax");
        game_board[5] = new Train("Train 1");
        game_board[6] = new Street("Oriental Avenue");
        game_board[7] = new Chance();
        game_board[8] = new Street("Vermont Avenue");
        game_board[9] = new Street("Connecticut Avenue");
        game_board[10] = new Jail("Jail");
        game_board[11] = new Street("St Charles Place");
        game_board[12] = new Electricity("Electric");
        game_board[13] = new Street("States Avenue");
        game_board[14] = new Street("Virginia Avenue");
        game_board[15] = new Train("Train 2");
        game_board[16] = new Street("St James Place");
        game_board[17] = new Street("Tennessee Avenue");
        game_board[18] = new Community_chest();
        game_board[19] = new Street("New York Avenue");
        game_board[20] = new Square("Parking");
        game_board[21] = new Street("Kentucky Avenue");
        game_board[22] = new Chance();
        game_board[23] = new Street("Indiana Avenue");
        game_board[24] = new Street("Illinois Avenue");
        game_board[25] = new Train("Train 3");
        game_board[26] = new Street("Atlantic Avenue");
        game_board[27] = new Street("Ventnor Avenue");
        game_board[28] = new Water();
        game_board[29] = new Street("Marvin Gardens");
        game_board[30] = new Square("Go to jail");
        game_board[31] = new Street("Pacific Avenue");
        game_board[32] = new Street("North Carolina Avenue");
        game_board[33] = new Community_chest();
        game_board[34] = new Street("Pennsylvania Avenue");
        game_board[35] = new Train("Train 4");
        game_board[36] = new Chance();
        game_board[37] = new Street("Park Place");
        game_board[38] = new Street("Luxury");
        game_board[39] = new Street("Boardwalk");



    }

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

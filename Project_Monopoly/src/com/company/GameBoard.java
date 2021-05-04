package com.company;

public abstract class GameBoard
{
    Square [] game_board = new Square[40];
    protected GameBoard()
    {
        game_board[0] = new Square("Go");
        game_board[1] = new Street("Mediterranean Avenue", 60, 2);
        game_board[2] = new Square("Chest");
        game_board[3] = new Street("Baltic Avenue", 60, 4);
        game_board[4] = new Square("Tax");
        game_board[5] = new Train("Train 1", 200, 25);
        game_board[6] = new Street("Oriental Avenue", 100, 6);
        game_board[7] = new Square("Chance");
        game_board[8] = new Street("Vermont Avenue", 100, 6);
        game_board[9] = new Street("Connecticut Avenue", 120, 8);
        game_board[10] = new Jail();
        game_board[11] = new Street("St Charles Place", 140, 10);
        game_board[12] = new Electricity("Electricity",150,12);
        game_board[13] = new Street("States Avenue", 140, 10);
        game_board[14] = new Street("Virginia Avenue", 160, 12);
        game_board[15] = new Train("Train 2", 200, 25);
        game_board[16] = new Street("St James Place", 180, 14);
        game_board[17] = new Square("Chest");
        game_board[18] = new Street("Tennessee Avenue", 180, 14);
        game_board[19] = new Street("New York Avenue", 200, 16);
        game_board[20] = new Square("Parking");
        game_board[21] = new Street("Kentucky Avenue", 220, 18);
        game_board[22] = new Square("Chance");
        game_board[23] = new Street("Indiana Avenue", 220, 18);
        game_board[24] = new Street("Illinois Avenue", 240, 20);
        game_board[25] = new Train("Train 3", 200, 25);
        game_board[26] = new Street("Atlantic Avenue", 260, 22);
        game_board[27] = new Street("Ventnor Avenue", 260, 22);
        game_board[28] = new Water("Water",150,12);
        game_board[29] = new Street("Marvin Gardens", 290, 24);
        game_board[30] = new Square("Go to jail");
        game_board[31] = new Street("Pacific Avenue", 300,  26);
        game_board[32] = new Street("North Carolina Avenue", 300, 26);
        game_board[33] = new Square("Chest");
        game_board[34] = new Street("Pennsylvania Avenue", 320, 26);
        game_board[35] = new Train("Train 4", 200, 25);
        game_board[36] = new Square("Chance");
        game_board[37] = new Street("Park Place", 350, 35);
        game_board[38] = new Square ("Luxury");
        game_board[39] = new Street("Boardwalk", 400, 50);
    }
}

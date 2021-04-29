package com.company;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private static Scanner inp = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    Square [] game_board = new Square[40];
    Game (String player1, String player2, String player3, String player4)
    {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.player3 = new Player(player3);
        this.player4 = new Player(player4);
        game_board[0] = new Square("Go");
        game_board[1] = new Street("Mediterranean Avenue", 60);
        game_board[2] = new Community_chest();
        game_board[3] = new Street("Baltic Avenue", 60);
        game_board[4] = new Square("Tax");
        game_board[5] = new Train("Train 1");
        game_board[6] = new Street("Oriental Avenue", 100);
        game_board[7] = new Chance();
        game_board[8] = new Street("Vermont Avenue", 100);
        game_board[9] = new Street("Connecticut Avenue", 120);
        game_board[10] = new Jail();
        game_board[11] = new Street("St Charles Place", 140);
        game_board[12] = new Electricity();
        game_board[13] = new Street("States Avenue", 140);
        game_board[14] = new Street("Virginia Avenue", 160);
        game_board[15] = new Train("Train 2");
        game_board[16] = new Street("St James Place", 180);
        game_board[17] = new Street("Tennessee Avenue", 180);
        game_board[18] = new Community_chest();
        game_board[19] = new Street("New York Avenue", 200);
        game_board[20] = new Square("Parking");
        game_board[21] = new Street("Kentucky Avenue", 220);
        game_board[22] = new Chance();
        game_board[23] = new Street("Indiana Avenue", 220);
        game_board[24] = new Street("Illinois Avenue", 240);
        game_board[25] = new Train("Train 3");
        game_board[26] = new Street("Atlantic Avenue", 260);
        game_board[27] = new Street("Ventnor Avenue", 260);
        game_board[28] = new Water();
        game_board[29] = new Street("Marvin Gardens", 290);
        game_board[30] = new Square("Go to jail");
        game_board[31] = new Street("Pacific Avenue", 300);
        game_board[32] = new Street("North Carolina Avenue", 300);
        game_board[33] = new Community_chest();
        game_board[34] = new Street("Pennsylvania Avenue", 320);
        game_board[35] = new Train("Train 4");
        game_board[36] = new Chance();
        game_board[37] = new Street("Park Place", 350);
        game_board[38] = new Square ("Luxury");
        game_board[39] = new Street("Boardwalk", 400);
    }
    private static Integer [] player_list = {0 , 0 , 0 , 0};
    protected void Print_board ()
    {

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
        int dice_roll = 0;
        takeTurns();
        String command = inp.next();
        if(command.equals("throw"))
        {
             dice_roll = diceRoll();
        }
        else
        {
            System.exit(0);
        }
        int c = game_board.length - player_list[turn-1];
        System.out.println("Dice - " + dice_roll);
        System.out.println("Current position - " + player_list[turn-1]);
        player_list[turn-1] += dice_roll;
        if(player_list[turn-1] > 39)
        {
            if(turn == 1)
            {
                player1.giveMoney(200);
            }
            if(turn == 2)
            {
                player2.giveMoney(200);
            }
            if(turn == 3)
            {
                player3.giveMoney(200);
            }
            if(turn == 4)
            {
                player4.giveMoney(200);
            }
            player_list[turn-1] = 0;
            player_list[turn-1] += dice_roll - c;

        }
        System.out.println("Next position - " + player_list[turn-1]);
        Feedback();
        System.out.println();
    }
    protected void Feedback()
    {

        if(turn == 1)
        {
            System.out.println(player1.getPlayerName() + " your budget is - " + player1.getPlayer_budget());
            System.out.println(player1.getPlayerName() + " you are on - " + game_board[player_list[turn-1]].getName());
            if(game_board[player_list[turn-1]] instanceof Street)
            {
                if(((Street) game_board[player_list[turn-1]]).isOwned() == false)
                {
                    System.out.println(player1.getPlayerName() + "do you wish to buy this street ? |y,n| - ");
                    char input;
                    input = inp.next().charAt(0);
                    if(input == 'y')
                    {
                        if(player1.getPlayer_budget() > ((Street) game_board[player_list[turn - 1]]).getPrice())
                        {
                            player1.takeMoney(((Street) game_board[player_list[turn - 1]]).getPrice());
                            ((Street) game_board[player_list[turn-1]]).Own(player1, true);
                            System.out.println("Congratulations " + player1.getPlayerName() + "you bought a property");
                        }
                        else
                        {
                            System.out.println("you don't have enough money !!!");
                        }

                    }
                }
                else
                {
                    System.out.println("The Owner of this property is - " + ((Street) game_board[player_list[turn - 1]]).getOwner());
                }
            }
        }
        if(turn == 2)
        {
            System.out.println(player2.getPlayerName() + " your budget is - " + player2.getPlayer_budget());
            System.out.println(player2.getPlayerName() + " you are on - " + game_board[player_list[turn-1]].getName());
            if(game_board[player_list[turn-1]] instanceof Street)
            {
                if(((Street) game_board[player_list[turn-1]]).isOwned() == false)
                {
                    System.out.println(player2.getPlayerName() + "do you wish to buy this street ? |y,n| - ");
                    char input;
                    input = inp.next().charAt(0);
                    if(input == 'y')
                    {
                        if(player2.getPlayer_budget() > ((Street) game_board[player_list[turn - 1]]).getPrice())
                        {
                            player2.takeMoney(((Street) game_board[player_list[turn - 1]]).getPrice());
                            ((Street) game_board[player_list[turn-1]]).Own(player2, true);
                            System.out.println("Congratulations " + player2.getPlayerName() + "you bought a property");
                        }
                        else
                        {
                            System.out.println("you don't have enough money !!!");
                        }
                    }
                }
                else
                {
                    System.out.println("Owner is - " + ((Street) game_board[player_list[turn - 1]]).getOwner());
                }
            }
        }
        if(turn == 3)
        {
            System.out.println(player3.getPlayerName() + " your budget is - " + player3.getPlayer_budget());
            System.out.println(player3.getPlayerName() + " you are on - " + game_board[player_list[turn-1]].getName());
            if(game_board[player_list[turn-1]] instanceof Street)
            {
                if(((Street) game_board[player_list[turn-1]]).isOwned() == false)
                {
                    System.out.println(player3.getPlayerName() + "do you wish to buy this street ? |y,n| - ");
                    char input;
                    input = inp.next().charAt(0);
                    if(input == 'y')
                    {
                        if(player3.getPlayer_budget() > ((Street) game_board[player_list[turn - 1]]).getPrice())
                        {
                            player3.takeMoney(((Street) game_board[player_list[turn - 1]]).getPrice());
                            ((Street) game_board[player_list[turn-1]]).Own(player3, true);
                            System.out.println("Congratulations " + player3.getPlayerName() + "you bought a property");
                        }
                        else
                        {
                            System.out.println("you don't have enough money !!!");
                        }
                    }
                }
                else
                {
                    System.out.println("Owner is - " + ((Street) game_board[player_list[turn - 1]]).getOwner());
                }
            }
        }
        if(turn == 4)
        {
            System.out.println(player4.getPlayerName() + " your budget is - " + player4.getPlayer_budget());
            System.out.println(player4.getPlayerName() + " you are on - " + game_board[player_list[turn-1]].getName());
            if(game_board[player_list[turn-1]] instanceof Street)
            {
                if(((Street) game_board[player_list[turn-1]]).isOwned() == false)
                {
                    System.out.println(player4.getPlayerName() + "do you wish to buy this street ? |y,n| - ");
                    char input;
                    input = inp.next().charAt(0);
                    if(input == 'y')
                    {
                        if(player4.getPlayer_budget() > ((Street) game_board[player_list[turn - 1]]).getPrice())
                        {
                            player4.takeMoney(((Street) game_board[player_list[turn - 1]]).getPrice());
                            ((Street) game_board[player_list[turn-1]]).Own(player1, true);
                            System.out.println("Congratulations " + player4.getPlayerName() + "you bought a property");
                        }
                        else
                        {
                            System.out.println("you don't have enough money !!!");
                        }
                    }
                }
                else
                {
                    System.out.println("Owner is - " + ((Street) game_board[player_list[turn - 1]]).getOwner());
                }
            }
        }
    }
    protected boolean gameOver()
    {
        if(this.player1.bankrupt() == false && this.player2.bankrupt() == true && this.player3.bankrupt() == true && this.player4.bankrupt() == true)
        {
            System.out.println("Game over, " + player1.getPlayerName() + " wins");
            return true;
        }
        if(this.player2.bankrupt() == false && this.player1.bankrupt() == true && this.player3.bankrupt() == true && this.player4.bankrupt() == true)
        {
            System.out.println("Game over, " + player2.getPlayerName() + " wins");
            return true;
        }
        if(this.player3.bankrupt() == false && this.player1.bankrupt() == true && this.player2.bankrupt() == true && this.player4.bankrupt() == true)
        {
            System.out.println("Game over, " + player3.getPlayerName() + " wins");
            return true;
        }
        if(this.player4.bankrupt() == false && this.player3.bankrupt() == true && this.player2.bankrupt() == true && this.player1.bankrupt() == true)
        {
            System.out.println("Game over, " + player4.getPlayerName() + " wins");
            return true;
        }
        return false;
    }
}

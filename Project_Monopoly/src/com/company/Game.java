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
    Player [] player_list = new Player[4];
    Game (String player1, String player2, String player3, String player4)
    {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.player3 = new Player(player3);
        this.player4 = new Player(player4);
        player_list [0] = this.player1;
        player_list [1] = this.player2;
        player_list [2] = this.player3;
        player_list [3] = this.player4;
        game_board[0] = new Square("Go");
        game_board[1] = new Street("Mediterranean Avenue", 60, 2);
        game_board[2] = new Community_chest();
        game_board[3] = new Street("Baltic Avenue", 60, 4);
        game_board[4] = new Square("Tax");
        game_board[5] = new Train("Train 1", 200, 25);
        game_board[6] = new Street("Oriental Avenue", 100, 6);
        game_board[7] = new Chance();
        game_board[8] = new Street("Vermont Avenue", 100, 6);
        game_board[9] = new Street("Connecticut Avenue", 120, 8);
        game_board[10] = new Jail();
        game_board[11] = new Street("St Charles Place", 140, 10);
        game_board[12] = new Electricity("Electricity",150,12);
        game_board[13] = new Street("States Avenue", 140, 10);
        game_board[14] = new Street("Virginia Avenue", 160, 12);
        game_board[15] = new Train("Train 2", 200, 25);
        game_board[16] = new Street("St James Place", 180, 14);
        game_board[17] = new Street("Tennessee Avenue", 180, 14);
        game_board[18] = new Community_chest();
        game_board[19] = new Street("New York Avenue", 200, 16);
        game_board[20] = new Square("Parking");
        game_board[21] = new Street("Kentucky Avenue", 220, 18);
        game_board[22] = new Chance();
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
        game_board[33] = new Community_chest();
        game_board[34] = new Street("Pennsylvania Avenue", 320, 26);
        game_board[35] = new Train("Train 4", 200, 25);
        game_board[36] = new Chance();
        game_board[37] = new Street("Park Place", 350, 35);
        game_board[38] = new Square ("Luxury");
        game_board[39] = new Street("Boardwalk", 400, 50);
    }
    enum chance_Cards {
        Advance_to_Go_Collect_$200,
        Advance_to_Illinois_Ave_If_you_pass_Go_collect_$200,
        Advance_to_St_Charles_Place_If_you_pass_Go_collect_$200,
        Advance_token_to_nearest_Utility_If_unowned_you_may_buy_it_from_the_Bank_If_owned_throw_dice_and_pay_owner_a_total_ten_times_the_amount_thrown,
        Advance_token_to_the_nearest_Railroad_and_pay_owner_twice_the_rental_to_which_he_or_she_is_otherwise_entitled_If_Railroad_is_unowned_you_may_buy_it_from_the_Bank,
        Bank_pays_you_dividend_of_$50,
        Get_Out_of_Jail_Free,
        Go_Back_3_Spaces,
        Go_to_Jail_Go_directly_to_Jail_Do_not_pass_Go_do_not_collect_$200,
        Make_general_repairs_on_all_your_property_For_each_house_pay_$25_For_each_hotel_$100,
        Pay_poor_tax_of_$15,
        Take_a_trip_to_Reading_Railroad_If_you_pass_Go_collect_$200,
        Take_a_walk_on_the_Boardwalk_Advance_token_to_Boardwalk,
        You_have_been_elected_Chairman_of_the_Board_Pay_each_player_$50,
        Your_building_and_loan_matures_Collect_$150,
        You_have_won_a_crossword_competition_Collect_$100
    }
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
        int c = game_board.length - player_list[turn-1].position;
        System.out.println("Dice - " + dice_roll);
        System.out.println("Current position - " + player_list[turn-1].position);
        player_list[turn-1].position += dice_roll;
        if(player_list[turn-1].position > 39)
        {
            player_list[turn-1].giveMoney(200);
            player_list[turn-1].position = 0;
            player_list[turn-1].position += dice_roll - c;

        }
        System.out.println("Next position - " + player_list[turn-1].position);
        Feedback();
        System.out.println();
    }
    protected void Feedback()
    {
        System.out.println(player_list[turn-1].getPlayerName() + " your budget is - " + player_list[turn-1].getPlayer_budget());
        System.out.println(player_list[turn-1].getPlayerName() + " you are on - " + game_board[player_list[turn-1].position].getName());
        if(game_board[player_list[turn-1].position] instanceof Street)
        {
            if(((Street) game_board[player_list[turn-1].position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Street) game_board[player_list[turn-1].position]).getPrice());
                System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this street ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player_list[turn-1].getPlayer_budget() > ((Street) game_board[player_list[turn - 1].position]).getPrice())
                    {
                        player_list[turn-1].takeMoney(((Street) game_board[player_list[turn - 1].position]).getPrice());
                        ((Street) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                        System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought a property");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }

                }
            }
            else if (((Street) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
            {
                System.out.println("The Owner of this property is - " + ((Street) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                player_list[turn-1].takeMoney(((Street) game_board[player_list[turn - 1].position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Street) game_board[player_list[turn - 1].position]).getOwner().giveMoney(((Street) game_board[player_list[turn - 1].position]).getRentPrice());
            }
        }
        if(game_board[player_list[turn-1].position] instanceof Train)
        {
            if(((Train) game_board[player_list[turn-1].position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Train) game_board[player_list[turn-1].position]).getPrice());
                System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player_list[turn-1].getPlayer_budget() > ((Train) game_board[player_list[turn - 1].position]).getPrice())
                    {
                        player_list[turn-1].takeMoney(((Train) game_board[player_list[turn - 1].position]).getPrice());
                        ((Train) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                        System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought a station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Train) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
            {
                System.out.println("The Owner of this station is - " + ((Train) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                player_list[turn-1].takeMoney(((Train) game_board[player_list[turn - 1].position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Train) game_board[player_list[turn - 1].position]).getOwner().giveMoney(((Train) game_board[player_list[turn - 1].position]).getRentPrice());
            }
        }
        if(game_board[player_list[turn-1].position] instanceof Water)
        {
            if(((Water) game_board[player_list[turn-1].position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Water) game_board[player_list[turn-1].position]).getPrice());
                System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player_list[turn-1].getPlayer_budget() > ((Water) game_board[player_list[turn - 1].position]).getPrice())
                    {
                        player_list[turn-1].takeMoney(((Water) game_board[player_list[turn - 1].position]).getPrice());
                        ((Water) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                        System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought Water station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Water) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
            {
                System.out.println("The Owner of this Water station is - " + ((Water) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                player_list[turn-1].takeMoney(((Water) game_board[player_list[turn - 1].position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Water) game_board[player_list[turn - 1].position]).getOwner().giveMoney(((Water) game_board[player_list[turn - 1].position]).getRentPrice());
            }
        }
        if(game_board[player_list[turn-1].position] instanceof Electricity)
        {
            if(((Electricity) game_board[player_list[turn-1].position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Electricity) game_board[player_list[turn-1].position]).getPrice());
                System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player_list[turn-1].getPlayer_budget() > ((Electricity) game_board[player_list[turn - 1].position]).getPrice())
                    {
                        player_list[turn-1].takeMoney(((Electricity) game_board[player_list[turn - 1].position]).getPrice());
                        ((Electricity) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                        System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought Electricity station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Electricity) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
            {
                System.out.println("The Owner of this Electricity station is - " + ((Electricity) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                player_list[turn-1].takeMoney(((Electricity) game_board[player_list[turn - 1].position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Electricity) game_board[player_list[turn - 1].position]).getOwner().giveMoney(((Electricity) game_board[player_list[turn - 1].position]).getRentPrice());
            }
        }
        if(game_board[player_list[turn-1].position] instanceof Chance){
            int card_number = 3;
            if (card_number == 0){
                System.out.println("Advance to Go (Collect $200)");
                player_list[turn-1].position = 0;
                player_list[turn-1].giveMoney(200);
            }
            else if(card_number == 1){
                System.out.println("Advance to Illinois Ave—If you pass Go, collect $200");
                if (player_list[turn-1].position > 24){
                    player_list[turn-1].giveMoney(200);
                }
                player_list[turn-1].position = 24;
            }
            else if(card_number == 2){
                System.out.println("Advance to St. Charles Place – If you pass Go, collect $200");
                if (player_list[turn-1].position > 11){
                    player_list[turn-1].giveMoney(200);
                }
                player_list[turn-1].position = 11;
            }
            else if(card_number == 3){
                System.out.println("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
                if (player_list[turn-1].position < 12 || player_list[turn-1].position > 28){
                    player_list[turn-1].position = 12;
                    if(!((Electricity) game_board[player_list[turn - 1].position]).isOwned())
                    {
                        System.out.println("Price is - " + ((Electricity) game_board[player_list[turn-1].position]).getPrice());
                        System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                        char input;
                        input = inp.next().charAt(0);
                        if(input == 'y')
                        {
                            if(player_list[turn-1].getPlayer_budget() > ((Electricity) game_board[player_list[turn - 1].position]).getPrice())
                            {
                                player_list[turn-1].takeMoney(((Electricity) game_board[player_list[turn - 1].position]).getPrice());
                                ((Electricity) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                                System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought Electricity station");
                            }
                            else
                            {
                                System.out.println("you don't have enough money !!!");
                            }
                        }
                    }
                    else if (((Electricity) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
                    {
                        System.out.println("The Owner of this Electricity station is - " + ((Electricity) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                        int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1))*10;
                        player_list[turn-1].takeMoney(player_tax);
                        System.out.println("Giving " + player_tax + " rent money to the owner");
                        ((Electricity) game_board[player_list[turn - 1].position]).getOwner().giveMoney(player_tax);
                    }
                }
                else {
                    player_list[turn-1].position=28;
                    if(!((Water) game_board[player_list[turn - 1].position]).isOwned())
                    {
                        System.out.println("Price is - " + ((Water) game_board[player_list[turn-1].position]).getPrice());
                        System.out.println(player_list[turn-1].getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                        char input;
                        input = inp.next().charAt(0);
                        if(input == 'y')
                        {
                            if(player_list[turn-1].getPlayer_budget() > ((Water) game_board[player_list[turn - 1].position]).getPrice())
                            {
                                player_list[turn-1].takeMoney(((Water) game_board[player_list[turn - 1].position]).getPrice());
                                ((Water) game_board[player_list[turn-1].position]).Own(player_list[turn-1], true);
                                System.out.println("Congratulations " + player_list[turn-1].getPlayerName() + " you bought Water station");
                            }
                            else
                            {
                                System.out.println("you don't have enough money !!!");
                            }
                        }
                    }
                    else if (((Water) game_board[player_list[turn-1].position]).getOwner() != player_list[turn-1])
                    {
                        System.out.println("The Owner of this Water station is - " + ((Water) game_board[player_list[turn - 1].position]).getOwner().getPlayerName());
                        int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1))*10;
                        player_list[turn-1].takeMoney(player_tax);
                        System.out.println("Giving " + player_tax + " rent money to the owner");
                        ((Water) game_board[player_list[turn - 1].position]).getOwner().giveMoney(player_tax);
                    }
                }
            }
            /*else if (card_number == 4) {

            }*/
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

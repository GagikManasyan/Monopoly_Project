package com.company;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Game extends GameBoard
{
    private static Scanner inp = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private static int turn = 0;
    private static int chance_count = -1;
    private static int chest_count = -1;
    private Player [] player_list = new Player[4];
    private Chance [] chance_cards = new Chance[16];
    private Community_Chest [] chest_cards = new Community_Chest[16];
    protected Game (String player1, String player2, String player3, String player4)
    {
        chest_cards[0] = new Community_Chest("Advance to Go. (Collect $200)",ActionType.MoveToGo, 0 );
        chest_cards[1] = new Community_Chest("Bank error in your favor. Collect $200",ActionType.GiveMoney, 200);
        chest_cards[2] = new Community_Chest("Doctor’s fee. Pay $50",ActionType.TakeMoney, 50);
        chest_cards[3] = new Community_Chest("From sale of stock you get $50",ActionType.GiveMoney , 50);
        chest_cards[4] = new Community_Chest("Get Out of Jail Free",ActionType.Jailcard,0);
        chest_cards[5] = new Community_Chest("Go to Jail. Go directly to jail, do not pass Go, do not collect $200",ActionType.Move , 30);
        chest_cards[6] = new Community_Chest("Holiday fund matures. Receive $100",ActionType.GiveMoney, 100);
        chest_cards[7] = new Community_Chest("Income tax refund. Collect $20",ActionType.GiveMoney, 20);
        chest_cards[8] = new Community_Chest("It is your birthday. Collect $10 from every player",ActionType.GiveMoney, 30);
        chest_cards[9] = new Community_Chest( "Life insurance matures. Collect $100",ActionType.GiveMoney,100);
        chest_cards[10] = new Community_Chest("Pay hospital fees of $100",ActionType.TakeMoney, 100);
        chest_cards[11] = new Community_Chest("Pay school fees of $50",ActionType.TakeMoney, 50);
        chest_cards[12] = new Community_Chest("Receive $25 consultancy fee",ActionType.GiveMoney, 25);
        chest_cards[13] = new Community_Chest("You are assessed for street repair. $40 per house. $115 per hotel",ActionType.PayForEachHotel, 115);
        chest_cards[14] = new Community_Chest( "You have won second prize in a beauty contest. Collect $10",ActionType.GiveMoney,10);
        chest_cards[15] = new Community_Chest( "You inherit $100",ActionType.GiveMoney,100);
        chance_cards[0] = new Chance("Advance to Go (Collect $200)",ActionType.MoveToGo, 0);
        chance_cards[1] = new Chance("Advance to Illinois Ave—If you pass Go, collect $200", ActionType.Move, 23);
        chance_cards[2] = new Chance("Advance to St. Charles Place – If you pass Go, collect $200", ActionType.Move, 11);
        chance_cards[3] = new Chance("Advance to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.", ActionType.MoveToClosestUtil, 0);
        chance_cards[4] = new Chance("Advance to the nearest Railroad and pay owner twice the rental to which he/she {he} is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.", ActionType.MoveToClosestRailRoad, 0);
        chance_cards[5] = new Chance("Bank pays you dividend of $50", ActionType.GiveMoney, 50);
        chance_cards[6] = new Chance("Get Out of Jail Free", ActionType.Jailcard, 0);
        chance_cards[7] = new Chance("Go Back 3 Spaces", ActionType.MoveBack, 3);
        chance_cards[8] = new Chance("Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200", ActionType.Move, 30);
        chance_cards[9] = new Chance("Make general repairs on all your property–For each house pay $25–For each hotel $100", ActionType.PayForEachHotel, 100);
        chance_cards[10] = new Chance("Pay poor tax of $15", ActionType.TakeMoney, 15);
        chance_cards[11] = new Chance("Take a trip to Reading Railroad–If you pass Go, collect $200", ActionType.Move, 5);
        chance_cards[12] = new Chance("Take a walk on the Boardwalk–Advance token to Boardwalk", ActionType.Move, 39);
        chance_cards[13] = new Chance("Pay each player $50", ActionType.TakeMoney, 50);
        chance_cards[14] = new Chance("Collect $150", ActionType.GiveMoney, 150);
        chance_cards[15] = new Chance("Collect $100", ActionType.GiveMoney, 100);
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.player3 = new Player(player3);
        this.player4 = new Player(player4);
        player_list [0] = this.player1;
        player_list [1] = this.player2;
        player_list [2] = this.player3;
        player_list [3] = this.player4;
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
    protected void Chance_Count()
    {
        chance_count += 1;
        if(chance_count > 15)
        {
            chance_count = 0;
        }

    }
    protected void Chest_Count()
    {
      chest_count += 1;
      if(chest_count > 15)
      {
          chest_count = 0;
      }
    }
    protected void Move()
    {
        /*((Street) game_board[1]).Own(player1,true);
        ((Street) game_board[3]).Own(player1,true);

        ((Street) game_board[6]).Own(player1,true);
        ((Street) game_board[8]).Own(player1,true);
        ((Street) game_board[9]).Own(player1,true);

        ((Street) game_board[11]).Own(player1,true);
        ((Street) game_board[13]).Own(player1,true);
        ((Street) game_board[14]).Own(player1,true);

        ((Street) game_board[16]).Own(player1,true);
        ((Street) game_board[18]).Own(player1,true);
        ((Street) game_board[19]).Own(player1,true);

        ((Street) game_board[21]).Own(player1,true);
        ((Street) game_board[23]).Own(player1,true);
        ((Street) game_board[24]).Own(player1,true);

        ((Street) game_board[26]).Own(player1,true);
        ((Street) game_board[27]).Own(player1,true);
        ((Street) game_board[29]).Own(player1,true);

        ((Street) game_board[31]).Own(player1,true);
        ((Street) game_board[32]).Own(player1,true);
        ((Street) game_board[34]).Own(player1,true);

        ((Street) game_board[37]).Own(player1,true);
        ((Street) game_board[39]).Own(player1,true);*/

        int dice_roll = 0;
        takeTurns();
        String command = "";
        int jaildayscount = 0;
        if(player_list[turn-1].isInJail() == true)
        {
            System.out.println(player_list[turn-1].getPlayerName() + " you are in Jail");
            jaildayscount = jaildayscount + 1;
            if(jaildayscount == 1)
            {
                jaildayscount = 0;
                player_list[turn-1].FreeJail();
            }
        }
        else
        {
            do
            {
                command = inp.next();
            }while (!command.equals("throw"));

            /*dice_roll = diceRoll();*/
            player_list[turn-1].position = 7;
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

    }
    protected void allSet ()
    {
        if(((Street) game_board[1]).isOwned() && ((Street) game_board[3]).isOwned())
        {
            if(((Street) game_board[1]).getOwner().equals(((Street) game_board[3]).getOwner()))
            {
                ((Street) game_board[1]).isSet(true);
                ((Street) game_board[3]).isSet(true);
            }
        }
        if(((Street) game_board[6]).isOwned() && ((Street) game_board[8]).isOwned() && ((Street) game_board[9]).isOwned())
        {
            if(((Street) game_board[6]).getOwner().equals(((Street) game_board[8]).getOwner()) && ((Street) game_board[6]).getOwner().equals(((Street) game_board[9]).getOwner()))
            {
                ((Street) game_board[6]).isSet(true);
                ((Street) game_board[8]).isSet(true);
                ((Street) game_board[9]).isSet(true);
            }
        }
        if(((Street) game_board[11]).isOwned() && ((Street) game_board[13]).isOwned() && ((Street) game_board[14]).isOwned())
        {
            if(((Street) game_board[11]).getOwner().equals(((Street) game_board[13]).getOwner()) && ((Street) game_board[11]).getOwner().equals(((Street) game_board[14]).getOwner()))
            {
                ((Street) game_board[11]).isSet(true);
                ((Street) game_board[13]).isSet(true);
                ((Street) game_board[14]).isSet(true);
            }
        }
        if(((Street) game_board[16]).isOwned() && ((Street) game_board[18]).isOwned() && ((Street) game_board[19]).isOwned())
        {
            if(((Street) game_board[16]).getOwner().equals(((Street) game_board[18]).getOwner()) && ((Street) game_board[16]).getOwner().equals(((Street) game_board[19]).getOwner()))
            {
                ((Street) game_board[16]).isSet(true);
                ((Street) game_board[18]).isSet(true);
                ((Street) game_board[19]).isSet(true);
            }
        }
        if(((Street) game_board[21]).isOwned() && ((Street) game_board[23]).isOwned() && ((Street) game_board[24]).isOwned())
        {
            if(((Street) game_board[21]).getOwner().equals(((Street) game_board[23]).getOwner()) && ((Street) game_board[21]).getOwner().equals(((Street) game_board[24]).getOwner()))
            {
                ((Street) game_board[21]).isSet(true);
                ((Street) game_board[23]).isSet(true);
                ((Street) game_board[24]).isSet(true);
            }
        }
        if(((Street) game_board[26]).isOwned() && ((Street) game_board[27]).isOwned() && ((Street) game_board[29]).isOwned())
        {
            if(((Street) game_board[26]).getOwner().equals(((Street) game_board[27]).getOwner()) && ((Street) game_board[26]).getOwner().equals(((Street) game_board[29]).getOwner()))
            {
                ((Street) game_board[26]).isSet(true);
                ((Street) game_board[27]).isSet(true);
                ((Street) game_board[29]).isSet(true);
            }
        }
        if(((Street) game_board[31]).isOwned() && ((Street) game_board[32]).isOwned() && ((Street) game_board[34]).isOwned())
        {
            if(((Street) game_board[31]).getOwner().equals(((Street) game_board[32]).getOwner()) && ((Street) game_board[31]).getOwner().equals(((Street) game_board[34]).getOwner()))
            {
                ((Street) game_board[31]).isSet(true);
                ((Street) game_board[32]).isSet(true);
                ((Street) game_board[34]).isSet(true);
            }
        }
        if(((Street) game_board[37]).isOwned() && ((Street) game_board[39]).isOwned())
        {
            if(((Street) game_board[37]).getOwner().equals(((Street) game_board[39]).getOwner()))
            {
                ((Street) game_board[37]).isSet(true);
                ((Street) game_board[39]).isSet(true);
            }
        }
    }
    protected void Feedback()
    {
        allSet();
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
                System.out.println("Rent - " + ((Street) game_board[player_list[turn - 1].position]).getRentPrice());
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
                int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                System.out.println("Throwing dice again - " + player_tax);
                System.out.println("Rent money - " + player_tax * 4);
                player_list[turn-1].takeMoney(player_tax * 4);
                ((Water) game_board[player_list[turn - 1].position]).getOwner().giveMoney(player_tax * 4);
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
                int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                System.out.println("Throwing dice again - " + player_tax);
                System.out.println("Rent money - " + player_tax * 4);
                player_list[turn-1].takeMoney(player_tax * 4);
                ((Electricity) game_board[player_list[turn - 1].position]).getOwner().giveMoney(player_tax * 4);
            }
        }
        if(game_board[player_list[turn-1].position].getName().equals("Chance"))
        {
            Chance_Count();
            chance_cards[chance_count].getText();
            chance_cards[chance_count].doAction(player_list[turn-1]);
            Feedback();

        }
        if(game_board[player_list[turn-1].position].getName().equals("Chest"))
        {
            Chest_Count();
            chest_cards[chest_count].getText();
            chest_cards[chest_count].doAction(player_list[turn-1]);
            Feedback();
        }
        if(player_list[turn-1].position == 30)
        {
            player_list[turn-1].goToJail();

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

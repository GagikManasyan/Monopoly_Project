package com.company;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Game extends GameBoard
{
    private static Scanner inp = new Scanner(System.in);
    private static int chance_count = -1;
    private static int chest_count = -1;
    private Chance [] chance_cards = new Chance[16];
    private Community_Chest [] chest_cards = new Community_Chest[16];
    protected Game ()
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
        chance_cards[1] = new Chance("Advance to Illinois Ave—If you pass Go, collect $200", ActionType.Move, 24);
        chance_cards[2] = new Chance("Advance to St. Charles Place – If you pass Go, collect $200", ActionType.Move, 11);
        chance_cards[3] = new Chance("Bank pays you dividend of $50", ActionType.GiveMoney, 50);
        chance_cards[4] = new Chance("Get Out of Jail Free", ActionType.Jailcard, 0);
        chance_cards[5] = new Chance("Go Back 3 Spaces", ActionType.MoveBack, 3);
        chance_cards[6] = new Chance("Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200", ActionType.Move, 30);
        chance_cards[7] = new Chance("Make general repairs on all your property–For each house pay $25–For each hotel $100", ActionType.PayForEachHotel, 100);
        chance_cards[8] = new Chance("Pay poor tax of $15", ActionType.TakeMoney, 15);
        chance_cards[9] = new Chance("Take a trip to Reading Railroad–If you pass Go, collect $200", ActionType.Move, 5);
        chance_cards[10] = new Chance("Take a walk on the Boardwalk–Advance token to Boardwalk", ActionType.Move, 39);
        chance_cards[11] = new Chance("Pay each player $50", ActionType.TakeMoney, 50);
        chance_cards[12] = new Chance("Collect $150", ActionType.GiveMoney, 150);
        chance_cards[13] = new Chance("Collect $100", ActionType.GiveMoney, 100);
        chance_cards[14] = new Chance("Pay $200", ActionType.TakeMoney, 200);
        chance_cards[15] = new Chance("Pay $100", ActionType.TakeMoney, 100);
    }
    protected int diceRoll()
    {
        int dice_roll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return dice_roll;
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
    protected void ShuffleCards ()
    {
        List<Chance> chance_cards_sh = Arrays.asList(chance_cards);
        Collections.shuffle(chance_cards_sh);
        this.chance_cards = chance_cards_sh.toArray(new Chance[chance_cards_sh.size()]);
        List<Community_Chest> chest_cards_sh = Arrays.asList(chest_cards);
        Collections.shuffle(chest_cards_sh);
        this.chest_cards = chest_cards_sh.toArray(new Community_Chest[chest_cards_sh.size()]);
    }
    protected void allSet ()
    {
        if(((Street) game_board[1]).isOwned() && ((Street) game_board[3]).isOwned())
        {
            if(((Street) game_board[1]).getOwner().equals(((Street) game_board[3]).getOwner()))
            {
                ((Street) game_board[1]).isSet(true, ((Street) game_board[1]).getOwner());
                ((Street) game_board[3]).isSet(true, ((Street) game_board[1]).getOwner());
            }
        }
        if(((Street) game_board[6]).isOwned() && ((Street) game_board[8]).isOwned() && ((Street) game_board[9]).isOwned())
        {
            if(((Street) game_board[6]).getOwner().equals(((Street) game_board[8]).getOwner()) && ((Street) game_board[6]).getOwner().equals(((Street) game_board[9]).getOwner()))
            {
                ((Street) game_board[6]).isSet(true, ((Street) game_board[6]).getOwner());
                ((Street) game_board[8]).isSet(true, ((Street) game_board[8]).getOwner());
                ((Street) game_board[9]).isSet(true, ((Street) game_board[9]).getOwner());
            }
        }
        if(((Street) game_board[11]).isOwned() && ((Street) game_board[13]).isOwned() && ((Street) game_board[14]).isOwned())
        {
            if(((Street) game_board[11]).getOwner().equals(((Street) game_board[13]).getOwner()) && ((Street) game_board[11]).getOwner().equals(((Street) game_board[14]).getOwner()))
            {
                ((Street) game_board[11]).isSet(true, ((Street) game_board[11]).getOwner());
                ((Street) game_board[13]).isSet(true, ((Street) game_board[13]).getOwner());
                ((Street) game_board[14]).isSet(true, ((Street) game_board[14]).getOwner());
            }
        }
        if(((Street) game_board[16]).isOwned() && ((Street) game_board[18]).isOwned() && ((Street) game_board[19]).isOwned())
        {
            if(((Street) game_board[16]).getOwner().equals(((Street) game_board[18]).getOwner()) && ((Street) game_board[16]).getOwner().equals(((Street) game_board[19]).getOwner()))
            {
                ((Street) game_board[16]).isSet(true, ((Street) game_board[16]).getOwner());
                ((Street) game_board[18]).isSet(true, ((Street) game_board[18]).getOwner());
                ((Street) game_board[19]).isSet(true, ((Street) game_board[19]).getOwner());
            }
        }
        if(((Street) game_board[21]).isOwned() && ((Street) game_board[23]).isOwned() && ((Street) game_board[24]).isOwned())
        {
            if(((Street) game_board[21]).getOwner().equals(((Street) game_board[23]).getOwner()) && ((Street) game_board[21]).getOwner().equals(((Street) game_board[24]).getOwner()))
            {
                ((Street) game_board[21]).isSet(true, ((Street) game_board[21]).getOwner());
                ((Street) game_board[23]).isSet(true, ((Street) game_board[23]).getOwner());
                ((Street) game_board[24]).isSet(true, ((Street) game_board[24]).getOwner());
            }
        }
        if(((Street) game_board[26]).isOwned() && ((Street) game_board[27]).isOwned() && ((Street) game_board[29]).isOwned())
        {
            if(((Street) game_board[26]).getOwner().equals(((Street) game_board[27]).getOwner()) && ((Street) game_board[26]).getOwner().equals(((Street) game_board[29]).getOwner()))
            {
                ((Street) game_board[26]).isSet(true, ((Street) game_board[26]).getOwner());
                ((Street) game_board[27]).isSet(true, ((Street) game_board[27]).getOwner());
                ((Street) game_board[29]).isSet(true, ((Street) game_board[29]).getOwner());
            }
        }
        if(((Street) game_board[31]).isOwned() && ((Street) game_board[32]).isOwned() && ((Street) game_board[34]).isOwned())
        {
            if(((Street) game_board[31]).getOwner().equals(((Street) game_board[32]).getOwner()) && ((Street) game_board[31]).getOwner().equals(((Street) game_board[34]).getOwner()))
            {
                ((Street) game_board[31]).isSet(true, ((Street) game_board[31]).getOwner());
                ((Street) game_board[32]).isSet(true, ((Street) game_board[32]).getOwner());
                ((Street) game_board[34]).isSet(true, ((Street) game_board[34]).getOwner());
            }
        }
        if(((Street) game_board[37]).isOwned() && ((Street) game_board[39]).isOwned())
        {
            if(((Street) game_board[37]).getOwner().equals(((Street) game_board[39]).getOwner()))
            {
                ((Street) game_board[37]).isSet(true, ((Street) game_board[37]).getOwner());
                ((Street) game_board[39]).isSet(true, ((Street) game_board[39]).getOwner());
            }
        }
    }
    protected void addHouse (Player player)
    {
        int index;
        System.out.print("Where ? Input the Index : ");
        index = inp.nextInt();
        if(((Street) game_board[index]).getOwner() == player && ((Street) game_board[index]).getSet() == true)
        {
            int house;
            do
            {
                System.out.println("Note you cannot build more than 4 houses");
                System.out.print("How many :");
                house = inp.nextInt();

            }while(house > 4);
            if(player.getPlayer_budget() < (((Street) game_board[index]).getHousePrice()) * house)
            {
                System.out.println("Not enough money !");
            }
            else
            {
                ((Street) game_board[index]).AddHouse(1);
                System.out.println("You built an house");
            }

        }
    }
    protected void addHotel (Player player)
    {
       int index;
       System.out.print("Where ? Input the Index of a street where you have 4 houses : ");
       index = inp.nextInt();
       if(((Street) game_board[index]).getOwner() == player && ((Street) game_board[index]).getSet() == true)
       {
           if(((Street) game_board[index]).getHouse_count() == 4)
           {
               System.out.println(((Street) game_board[index]).getHouse_count());
               ((Street) game_board[index]).AddHotel();
               System.out.println("You built an hotel on " + game_board[index].getName());
           }
           else
           {
               System.out.println(((Street) game_board[index]).getHouse_count());
               System.out.println("You don't have 4 houses here !");
           }
       }
    }
    protected void Move(Player player, int dice_roll)
    {

        int jaildayscount = 0;
        if(player.isInJail() == true)
        {
            if(player.OutOfJailCard() == true)
            {
                System.out.print(player.getPlayerName() + " you have a jailfree card do you want to use it it ? y|n : ");
                char command = inp.next().charAt(0);
                if(command == 'y')
                {
                    player.FreeJail();
                    Move(player, dice_roll);
                }
                else
                {
                    System.out.println(player.getPlayerName() + " you are in Jail");
                    jaildayscount = jaildayscount + 1;
                    if(jaildayscount == 1)
                    {
                        player.FreeJail();
                    }
                }
            }
            else
            {
                System.out.println(player.getPlayerName() + " you are in Jail");
                jaildayscount = jaildayscount + 1;
                if(jaildayscount == 1)
                {
                    player.FreeJail();
                }
            }

        }
        else
        {
            int c = game_board.length - player.position;
            player.position += dice_roll;
            if(player.position > 39)
            {
                player.giveMoney(200);
                player.position = 0;
                player.position += dice_roll - c;

            }
        }

    }
    protected void Feedback(Player player)
    {
        System.out.println(player.getPlayerName() + " your budget is - " + player.getPlayer_budget());
        System.out.println(player.getPlayerName() + " you are on - " + game_board[player.position].getName());
        if(game_board[player.position] instanceof Street)
        {

            if(((Street) game_board[player.position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Street) game_board[player.position]).getPrice());
                System.out.print(player.getPlayerName() + " do you wish to buy this street ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player.getPlayer_budget() > ((Street) game_board[player.position]).getPrice())
                    {
                        player.takeMoney(((Street) game_board[player.position]).getPrice());
                        ((Street) game_board[player.position]).Own(player, true);
                        System.out.println("Congratulations " + player.getPlayerName() + " you bought a property");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }

                }
            }
            else if (((Street) game_board[player.position]).getOwner() != player)
            {
                System.out.println("The Owner of this property is - " + ((Street) game_board[player.position]).getOwner().getPlayerName());
                System.out.println("Rent - " + ((Street) game_board[player.position]).getRentPrice());
                player.takeMoney(((Street) game_board[player.position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Street) game_board[player.position]).getOwner().giveMoney(((Street) game_board[player.position]).getRentPrice());
            }

        }
        if(game_board[player.position] instanceof Train)
        {
            if(((Train) game_board[player.position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Train) game_board[player.position]).getPrice());
                System.out.print(player.getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player.getPlayer_budget() > ((Train) game_board[player.position]).getPrice())
                    {
                        player.takeMoney(((Train) game_board[player.position]).getPrice());
                        ((Train) game_board[player.position]).Own(player, true);
                        System.out.println("Congratulations " + player.getPlayerName() + " you bought a station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Train) game_board[player.position]).getOwner() != player)
            {
                System.out.println("The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName());
                player.takeMoney(((Train) game_board[player.position]).getRentPrice());
                System.out.println("Giving rent money to the owner");
                ((Train) game_board[player.position]).getOwner().giveMoney(((Train) game_board[player.position]).getRentPrice());
            }
        }
        if(game_board[player.position] instanceof Water)
        {
            if(((Water) game_board[player.position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Water) game_board[player.position]).getPrice());
                System.out.print(player.getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player.getPlayer_budget() > ((Water) game_board[player.position]).getPrice())
                    {
                        player.takeMoney(((Water) game_board[player.position]).getPrice());
                        ((Water) game_board[player.position]).Own(player, true);
                        System.out.println("Congratulations " + player.getPlayerName() + " you bought Water station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Water) game_board[player.position]).getOwner() != player)
            {
                System.out.println("The Owner of this Water station is - " + ((Water) game_board[player.position]).getOwner().getPlayerName());
                int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                if(game_board[12].isOwned() && game_board[28].isOwned() && game_board[12].getOwner().equals(game_board[28].getOwner()))
                {
                    System.out.println("Throwing dice again - " + player_tax);
                    System.out.println("Rent money - " + player_tax * 10);
                    player.takeMoney(player_tax * 10);
                    ((Water) game_board[player.position]).getOwner().giveMoney(player_tax * 10);

                }
                else
                {
                    System.out.println("Throwing dice again - " + player_tax);
                    System.out.println("Rent money - " + player_tax * 4);
                    player.takeMoney(player_tax * 4);
                    ((Water) game_board[player.position]).getOwner().giveMoney(player_tax * 4);
                }

            }
        }
        if(game_board[player.position] instanceof Electricity)
        {
            if(((Electricity) game_board[player.position]).isOwned() == false)
            {
                System.out.println("Price is - " + ((Electricity) game_board[player.position]).getPrice());
                System.out.print(player.getPlayerName() + " do you wish to buy this station ? |y,n| - ");
                char input;
                input = inp.next().charAt(0);
                if(input == 'y')
                {
                    if(player.getPlayer_budget() > ((Electricity) game_board[player.position]).getPrice())
                    {
                        player.takeMoney(((Electricity) game_board[player.position]).getPrice());
                        ((Electricity) game_board[player.position]).Own(player, true);
                        System.out.println("Congratulations " + player.getPlayerName() + " you bought Electricity station");
                    }
                    else
                    {
                        System.out.println("you don't have enough money !!!");
                    }
                }
            }
            else if (((Electricity) game_board[player.position]).getOwner() != player)
            {
                System.out.println("The Owner of this Electricity station is - " + ((Electricity) game_board[player.position]).getOwner().getPlayerName());
                int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                if(game_board[12].isOwned() && game_board[28].isOwned() && game_board[12].getOwner().equals(game_board[28].getOwner()))
                {
                    System.out.println("Throwing dice again - " + player_tax);
                    System.out.println("Rent money - " + player_tax * 10);
                    player.takeMoney(player_tax * 10);
                    ((Electricity) game_board[player.position]).getOwner().giveMoney(player_tax * 10);

                }
                else
                {
                    System.out.println("Throwing dice again - " + player_tax);
                    System.out.println("Rent money - " + player_tax * 4);
                    player.takeMoney(player_tax * 4);
                    ((Electricity) game_board[player.position]).getOwner().giveMoney(player_tax * 4);
                }

            }
        }
        if(game_board[player.position].getName().equals("Chance"))
        {
            Chance_Count();
            chance_cards[chance_count].getText();
            chance_cards[chance_count].doAction(player);
            if(chance_cards[chance_count].getActionTypet().equals(ActionType.Move))
            {
                Feedback(player);
            }


        }
        if(game_board[player.position].getName().equals("Chest"))
        {
            Chest_Count();
            chest_cards[chest_count].getText();
            chest_cards[chest_count].doAction(player);
            if(chest_cards[chest_count].getActionTypet().equals(ActionType.Move))
            {
                Feedback(player);
            }
        }
        if(game_board[player.position].getName().equals("Income Tax"))
        {
            System.out.println("Income Tax. Taking 200 from the player");
            player.takeMoney(200);
        }
        if(game_board[player.position].getName().equals("Luxury Tax"))
        {
            System.out.println("Luxury Tax. Taking 100 from the player");
            player.takeMoney(100);
        }
        if(player.position == 30)
        {
            player.goToJail();

        }

    }

}

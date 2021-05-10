package com.company;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Game extends GameBoard
{
    ///Game class with the functionallity of the game
    private static int chance_count = -1;
    private static int chest_count = -1;
    private Chance [] chance_cards = new Chance[16];
    private Community_Chest [] chest_cards = new Community_Chest[16];
    protected Game (Player player)
    {
        chest_cards[0] = new Community_Chest("Advance to Go. (Collect $200)",ActionType.MoveToGo, 0 );
        chest_cards[1] = new Community_Chest("Bank error in your favor. Collect $200",ActionType.GiveMoney, 200);
        chest_cards[2] = new Community_Chest("Doctor’s fee. Pay $50",ActionType.TakeMoney, 50);
        chest_cards[3] = new Community_Chest("From sale of stock you get $50",ActionType.GiveMoney , 50);
        chest_cards[4] = new Community_Chest("Get Out of Jail card",ActionType.Jailcard,0);
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
        chance_cards[11] = new Chance("Pay $50", ActionType.TakeMoney, 50);
        chance_cards[12] = new Chance("Collect $150", ActionType.GiveMoney, 150);
        chance_cards[13] = new Chance("Collect $100", ActionType.GiveMoney, 100);
        chance_cards[14] = new Chance("Pay $200", ActionType.TakeMoney, 200);
        chance_cards[15] = new Chance("Pay $100", ActionType.TakeMoney, 100);

        ((Street) game_board[1]).Own(player, true);
        ((Street) game_board[3]).Own(player, true);

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
    protected void Sell(Player player)
    {
        String info = "Your Properties" + "\n";
        for (int i = 0; i < game_board.length; i++)
        {
            if(game_board[i].isOwned() == true && game_board[i].getOwner().equals(player))
            {
                info += game_board[i].getName() + "\n";
            }

        }
        String propertyname = JOptionPane.showInputDialog(null,info,"Sell",JOptionPane.PLAIN_MESSAGE);
        if(propertyname != null)
        {
            for (int i = 0; i < game_board.length; i++)
            {
                if(game_board[i].getName().equals(propertyname))
                {
                    if(game_board[i] instanceof Street)
                    {
                        ((Street) game_board[i]).Sell();
                        ((Street) game_board[i]).isSet(false,player);
                        player.giveMoney(((Street) game_board[i]).getPrice() + ((Street) game_board[i]).getHouse_count() * ((Street) game_board[i]).getHousePrice() + ((Street) game_board[i]).getHotelPrice());
                    }
                    if(game_board[i] instanceof Train)
                    {
                        ((Train) game_board[i]).Sell();
                        player.giveMoney(((Train) game_board[i]).getPrice());
                    }
                    if(game_board[i] instanceof Water)
                    {
                        ((Water) game_board[i]).Sell();
                        player.giveMoney(((Water) game_board[i]).getPrice());
                    }
                    if(game_board[i] instanceof Electricity)
                    {
                        ((Electricity) game_board[i]).Sell();
                        player.giveMoney(((Electricity) game_board[i]).getPrice());
                    }
                }
            }
        }

    }
    protected void addHouse (Player player)
    {

        String info = "Your Streets: \n";
        if(game_board[1].isOwned() == true && game_board[3].isOwned() == true && game_board[1].getOwner().equals(player) && ((Street) game_board[1]).getSet() == true)
        {
            String str = game_board[1].getName();
            info += str + " " + game_board[3].getName() + "\n";
        }
        if(game_board[6].isOwned() == true && game_board[8].isOwned() == true && game_board[9].isOwned() == true && game_board[6].getOwner().equals(player) && ((Street) game_board[6]).getSet() == true)
        {
            info += game_board[6].getName()   + " " + game_board[8].getName() + " " + game_board[9] + "\n";
        }
        if(game_board[11].isOwned() == true && game_board[13].isOwned() == true && game_board[14].isOwned() == true && game_board[11].getOwner().equals(player) && ((Street) game_board[11]).getSet() == true)
        {
            info += game_board[11].getName()   + " " + game_board[13].getName() + " " + game_board[14] + "\n";
        }
        if(game_board[16].isOwned() == true && game_board[18].isOwned() == true && game_board[19].isOwned() == true && game_board[16].getOwner().equals(player) && ((Street) game_board[16]).getSet() == true)
        {
            info += game_board[16].getName()   + " " + game_board[18].getName() + " " + game_board[19] + "\n";
        }
        if(game_board[21].isOwned() == true && game_board[23].isOwned() == true && game_board[24].isOwned() == true && game_board[21].getOwner().equals(player) && ((Street) game_board[21]).getSet() == true)
        {
            info += game_board[21].getName()   + " " + game_board[23].getName() + " " + game_board[24] + "\n";
        }
        if(game_board[26].isOwned() == true && game_board[27].isOwned() == true && game_board[29].isOwned() == true && game_board[26].getOwner().equals(player) && ((Street) game_board[26]).getSet() == true)
        {
            info += game_board[26].getName()   + " " + game_board[27].getName() + " " + game_board[29] + "\n";
        }
        if(game_board[31].isOwned() == true && game_board[32].isOwned() == true && game_board[34].isOwned() == true && game_board[31].getOwner().equals(player) && ((Street) game_board[31]).getSet() == true)
        {
            info += game_board[31].getName()   + " " + game_board[32].getName() + " " + game_board[34] + "\n";
        }
        if(game_board[37].isOwned() == true && game_board[39].isOwned() == true && game_board[37].getOwner().equals(player) && ((Street) game_board[37]).getSet() == true)
        {
            info += game_board[37].getName()   + " " + game_board[39].getName() + "\n";
        }
        String streetname = JOptionPane.showInputDialog(null,info,"SelectStreet",JOptionPane.PLAIN_MESSAGE);
        Street street = FindStreet(streetname);
        if(street != null)
        {
            if(street.getHouse_count() == 4 || street.getHotel_count() == 1)
            {
                JOptionPane.showMessageDialog(null,"this Street is full ! ");
            }
            else
            {
                String number = JOptionPane.showInputDialog(null, "How Many houses do you wish to build ?","BuildHouse",JOptionPane.PLAIN_MESSAGE);
                int n = Integer.parseInt(number);
                if(street.getHouse_count() + n > 4)
                {
                    JOptionPane.showMessageDialog(null,"You cannot have more than 4 houses ! ");
                }
                else
                {
                    street.AddHouse(n,player);
                    player.takeMoney(street.getHousePrice() * n);
                    JOptionPane.showMessageDialog(null,"Congratulations you bought a house on " + street.getName());
                }
            }
        }
    }
    protected void addHotel (Player player)
    {
        String info = "Your Streets: \n";
        if(game_board[1].isOwned() == true && game_board[3].isOwned() == true && game_board[1].getOwner().equals(player) && ((Street) game_board[1]).getSet() == true)
        {
            String str = game_board[1].getName();
            info += str + " " + game_board[3].getName() + "\n";
        }
        if(game_board[6].isOwned() == true && game_board[8].isOwned() == true && game_board[9].isOwned() == true && game_board[6].getOwner().equals(player) && ((Street) game_board[6]).getSet() == true)
        {
            info += game_board[6].getName()   + " " + game_board[8].getName() + " " + game_board[9] + "\n";
        }
        if(game_board[11].isOwned() == true && game_board[13].isOwned() == true && game_board[14].isOwned() == true && game_board[11].getOwner().equals(player) && ((Street) game_board[11]).getSet() == true)
        {
            info += game_board[11].getName()   + " " + game_board[13].getName() + " " + game_board[14] + "\n";
        }
        if(game_board[16].isOwned() == true && game_board[18].isOwned() == true && game_board[19].isOwned() == true && game_board[16].getOwner().equals(player) && ((Street) game_board[16]).getSet() == true)
        {
            info += game_board[16].getName()   + " " + game_board[18].getName() + " " + game_board[19] + "\n";
        }
        if(game_board[21].isOwned() == true && game_board[23].isOwned() == true && game_board[24].isOwned() == true && game_board[21].getOwner().equals(player) && ((Street) game_board[21]).getSet() == true)
        {
            info += game_board[21].getName()   + " " + game_board[23].getName() + " " + game_board[24] + "\n";
        }
        if(game_board[26].isOwned() == true && game_board[27].isOwned() == true && game_board[29].isOwned() == true && game_board[26].getOwner().equals(player) && ((Street) game_board[26]).getSet() == true)
        {
            info += game_board[26].getName()   + " " + game_board[27].getName() + " " + game_board[29] + "\n";
        }
        if(game_board[31].isOwned() == true && game_board[32].isOwned() == true && game_board[34].isOwned() == true && game_board[31].getOwner().equals(player) && ((Street) game_board[31]).getSet() == true)
        {
            info += game_board[31].getName()   + " " + game_board[32].getName() + " " + game_board[34] + "\n";
        }
        if(game_board[37].isOwned() == true && game_board[39].isOwned() == true && game_board[37].getOwner().equals(player) && ((Street) game_board[37]).getSet() == true)
        {
            info += game_board[37].getName()   + " " + game_board[39].getName() + "\n";
        }
        String streetname = JOptionPane.showInputDialog(null,info,"SelectStreet",JOptionPane.PLAIN_MESSAGE);
        Street street = FindStreet(streetname);
        if(street != null)
        {
            if(street.getHouse_count() == 1)
            {
                JOptionPane.showMessageDialog(null,"this Street is full ! ");
            }
            else
            {
                street.AddHotel(player);
                player.takeMoney(street.getHotelPrice());
                JOptionPane.showMessageDialog(null,"Congratulations you bought a hotel on " + street.getName());
                }
            }
        }
    protected Street FindStreet (String name)
    {
        if(game_board[1].getName().equals(name))
        {
            return ((Street) game_board[1]);
        }
        if(game_board[3].getName().equals(name))
        {
            return ((Street) game_board[3]);
        }
        if(game_board[6].getName().equals(name))
        {
            return ((Street) game_board[6]);
        }
        if(game_board[8].getName().equals(name))
        {
            return ((Street) game_board[8]);
        }
        if(game_board[9].getName().equals(name))
        {
            return ((Street) game_board[9]);
        }
        if(game_board[11].getName().equals(name))
        {
            return ((Street) game_board[11]);
        }
        if(game_board[13].getName().equals(name))
        {
            return ((Street) game_board[13]);
        }
        if(game_board[14].getName().equals(name))
        {
            return ((Street) game_board[14]);
        }
        if(game_board[16].getName().equals(name))
        {
            return ((Street) game_board[16]);
        }
        if(game_board[18].getName().equals(name))
        {
            return ((Street) game_board[18]);
        }
        if(game_board[19].getName().equals(name))
        {
            return ((Street) game_board[19]);
        }
        if(game_board[21].getName().equals(name))
        {
            return ((Street) game_board[21]);
        }
        if(game_board[23].getName().equals(name))
        {
            return ((Street) game_board[23]);
        }
        if(game_board[24].getName().equals(name))
        {
            return ((Street) game_board[24]);
        }
        if(game_board[26].getName().equals(name))
        {
            return ((Street) game_board[26]);
        }
        if(game_board[27].getName().equals(name))
        {
            return ((Street) game_board[27]);
        }
        if(game_board[29].getName().equals(name))
        {
            return ((Street) game_board[29]);
        }
        if(game_board[31].getName().equals(name))
        {
            return ((Street) game_board[31]);
        }
        if(game_board[32].getName().equals(name))
        {
            return ((Street) game_board[32]);
        }
        if(game_board[34].getName().equals(name))
        {
            return ((Street) game_board[34]);
        }
        if(game_board[37].getName().equals(name))
        {
            return ((Street) game_board[37]);
        }
        if(game_board[39].getName().equals(name))
        {
            return ((Street) game_board[39]);
        }
        return null;
    }


    protected void Move(Player player, int dice_roll)
    {

        int jaildayscount = 0;
        if(player.getPlayer_budget() <= 0)
        {
            JOptionPane.showMessageDialog(null,player.getPlayerName() + "You are bankrupt.");
        }
        else
        {
            if(player.isInJail() == true)
            {
                if(player.OutOfJailCard() == true)
                {
                    int command = JOptionPane.showConfirmDialog(null,"you have FreeJailCard do you wish to use it ?");
                    if(command == 0)
                    {
                        JOptionPane.showMessageDialog(null,"You are free !!");
                        player.FreeJail();
                        Move(player, dice_roll);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You are in Jail.");
                        jaildayscount = jaildayscount + 1;
                        if(jaildayscount == 1)
                        {
                            player.FreeJail();
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You are in Jail.");
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


    }
    protected void Feedback(Player player)
    {
        ShuffleCards();
        if(player.getPlayer_budget() <= 0)
        {

        }
        else
        {
            JOptionPane.showMessageDialog(null, "You are on : " + game_board[player.position].getName());
            if(game_board[player.position] instanceof Street)
            {

                if(((Street) game_board[player.position]).isOwned() == false)
                {
                    int n = JOptionPane.showConfirmDialog(null,"Your budget is - " + player.getPlayer_budget() + "\n"
                            + "Price is - " +  ((Street) game_board[player.position]).getPrice()
                            + "\n" + "Do you wish to buy this Street ? ");
                    if(n == 0)
                    {
                        if(player.getPlayer_budget() > ((Street) game_board[player.position]).getPrice())
                        {
                            player.takeMoney(((Street) game_board[player.position]).getPrice());
                            ((Street) game_board[player.position]).Own(player, true);
                            JOptionPane.showMessageDialog(null,"Congratulations " + player.getPlayerName() + " you bought a property");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You don't have enough money !!!");
                        }

                    }
                }
                else if (((Street) game_board[player.position]).getOwner() != player)
                {
                    player.takeMoney(((Street) game_board[player.position]).getRentPrice());
                    ((Street) game_board[player.position]).getOwner().giveMoney(((Street) game_board[player.position]).getRentPrice());
                    JOptionPane.showMessageDialog(null,"The Owner of this property is - " + ((Street) game_board[player.position]).getOwner().getPlayerName() + "\n"
                            + "Rent - " + ((Street) game_board[player.position]).getRentPrice() + "\n"
                            + "Giving money to the owner");
                }

            }
            if(game_board[player.position] instanceof Train)
            {
                if(((Train) game_board[player.position]).isOwned() == false)
                {
                    int n = JOptionPane.showConfirmDialog(null,"Your budget is - " + player.getPlayer_budget() + "\n"
                            + "Price is - " +  ((Train) game_board[player.position]).getPrice()
                            + "\n" + "Do you wish to buy this Train Station ? ");
                    if(n == 0)
                    {
                        if(player.getPlayer_budget() > ((Train) game_board[player.position]).getPrice())
                        {
                            player.takeMoney(((Train) game_board[player.position]).getPrice());
                            ((Train) game_board[player.position]).Own(player, true);
                            player.buyTrain();
                            JOptionPane.showMessageDialog(null,"Congratulations " + player.getPlayerName() + " you bought a property");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"you don't have enough money !!!");
                        }
                    }
                }
                else if (((Train) game_board[player.position]).getOwner() != player)
                {
                    System.out.println("The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName());
                    if(game_board[player.position].getOwner().getHasTrains() == 1)
                    {
                        JOptionPane.showMessageDialog(null,"The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Rent - " + ((Train) game_board[player.position]).getRentPrice() + "\n"
                                + "Giving money to the owner");
                        player.takeMoney(((Train) game_board[player.position]).getRentPrice());
                        ((Train) game_board[player.position]).getOwner().giveMoney(((Train) game_board[player.position]).getRentPrice());
                    }
                    else if (game_board[player.position].getOwner().getHasTrains() == 2){

                        JOptionPane.showMessageDialog(null,"The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Rent - " + ((Train) game_board[player.position]).getRentPrice()*2 + "\n"
                                + "Giving money to the owner");
                        player.takeMoney(((Train) game_board[player.position]).getRentPrice()*2);
                        ((Train) game_board[player.position]).getOwner().giveMoney(((Train) game_board[player.position]).getRentPrice()*2);
                    }
                    else if (game_board[player.position].getOwner().getHasTrains() == 3){
                        JOptionPane.showMessageDialog(null,"The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Rent - " + ((Train) game_board[player.position]).getRentPrice()*4 + "\n"
                                + "Giving money to the owner");
                        player.takeMoney(((Train) game_board[player.position]).getRentPrice()*4);
                        ((Train) game_board[player.position]).getOwner().giveMoney(((Train) game_board[player.position]).getRentPrice()*4);
                    }
                    else if (game_board[player.position].getOwner().getHasTrains() == 4){
                        JOptionPane.showMessageDialog(null,"The Owner of this station is - " + ((Train) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Rent - " + ((Train) game_board[player.position]).getRentPrice()*6 + "\n"
                                + "Giving money to the owner");
                        player.takeMoney(((Train) game_board[player.position]).getRentPrice()*6);
                        ((Train) game_board[player.position]).getOwner().giveMoney(((Train) game_board[player.position]).getRentPrice()*6);
                    }

                }
            }
            if(game_board[player.position] instanceof Water)
            {
                if(((Water) game_board[player.position]).isOwned() == false)
                {
                    int n = JOptionPane.showConfirmDialog(null,"Your budget is - " + player.getPlayer_budget() + "\n"
                            + "Price is - " +  ((Water) game_board[player.position]).getPrice()
                            + "\n" + "Do you wish to buy this Utility ? ");
                    if(n == 0)
                    {
                        if(player.getPlayer_budget() > ((Water) game_board[player.position]).getPrice())
                        {
                            player.takeMoney(((Water) game_board[player.position]).getPrice());
                            ((Water) game_board[player.position]).Own(player, true);
                            JOptionPane.showMessageDialog(null,"Congratulations " + player.getPlayerName() + " you bought a Utility");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"You don't have enough money !!!");
                        }
                    }
                }
                else if (((Water) game_board[player.position]).getOwner() != player)
                {
                    int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                    if(game_board[12].isOwned() && game_board[28].isOwned() && game_board[12].getOwner().equals(game_board[28].getOwner()))
                    {
                        JOptionPane.showMessageDialog(null,"The Owner of this Utility is - " + ((Water) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Throwing dice again - " + + player_tax + "\n"
                                + "Rent money - " + player_tax * 10
                                + "Giving money to the owner");
                        player.takeMoney(player_tax * 10);
                        ((Water) game_board[player.position]).getOwner().giveMoney(player_tax * 10);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The Owner of this Utility is - " + ((Water) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Throwing dice again - " + + player_tax + "\n"
                                + "Rent money - " + player_tax * 4
                                + "Giving money to the owner");
                        player.takeMoney(player_tax * 4);
                        ((Water) game_board[player.position]).getOwner().giveMoney(player_tax * 4);
                    }

                }
            }
            if(game_board[player.position] instanceof Electricity)
            {
                if(((Electricity) game_board[player.position]).isOwned() == false)
                {
                    int n = JOptionPane.showConfirmDialog(null,"Your budget is - " + player.getPlayer_budget() + "\n"
                            + "Price is - " +  ((Electricity) game_board[player.position]).getPrice()
                            + "\n" + "Do you wish to buy this Utility ? ");
                    if(n == 0)
                    {
                        if(player.getPlayer_budget() > ((Electricity) game_board[player.position]).getPrice())
                        {
                            player.takeMoney(((Electricity) game_board[player.position]).getPrice());
                            ((Electricity) game_board[player.position]).Own(player, true);
                            JOptionPane.showMessageDialog(null,"Congratulations " + player.getPlayerName() + "you bought Utility");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"you don't have enough money !!!");
                        }
                    }
                }
                else if (((Electricity) game_board[player.position]).getOwner() != player)
                {
                    int player_tax = (ThreadLocalRandom.current().nextInt(1, 6 + 1) + ThreadLocalRandom.current().nextInt(1, 6 + 1));
                    if(game_board[12].isOwned() && game_board[28].isOwned() && game_board[12].getOwner().equals(game_board[28].getOwner()))
                    {
                        JOptionPane.showMessageDialog(null,"The Owner of this Utility is - " + ((Electricity) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Throwing dice again - " + + player_tax + "\n"
                                + "Rent money - " + player_tax * 10
                                + "Giving money to the owner");
                        player.takeMoney(player_tax * 10);
                        ((Electricity) game_board[player.position]).getOwner().giveMoney(player_tax * 10);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The Owner of this Utility is - " + ((Electricity) game_board[player.position]).getOwner().getPlayerName() + "\n"
                                + "Throwing dice again - " + + player_tax + "\n"
                                + "Rent money - " + player_tax * 4
                                + "Giving money to the owner");
                        player.takeMoney(player_tax * 4);
                        ((Electricity) game_board[player.position]).getOwner().giveMoney(player_tax * 4);
                    }

                }
            }
            if(game_board[player.position].getName().equals("Chance"))
            {
                Chance_Count();
                JOptionPane.showMessageDialog(null, chance_cards[chance_count].getText());
                chance_cards[chance_count].doAction(player);
                if(chance_cards[chance_count].getActionTypet().equals(ActionType.Move) || chance_cards[chance_count].getActionTypet().equals(ActionType.MoveBack))
                {
                    Feedback(player);
                }


            }
            if(game_board[player.position].getName().equals("Chest"))
            {
                Chest_Count();
                JOptionPane.showMessageDialog(null, chest_cards[chest_count].getText());
                chest_cards[chest_count].doAction(player);
                if(chest_cards[chest_count].getActionTypet().equals(ActionType.Move) || chest_cards[chest_count].getActionTypet().equals(ActionType.MoveBack))
                {
                    Feedback(player);
                }
            }
            if(game_board[player.position].getName().equals("Income Tax"))
            {
                JOptionPane.showMessageDialog(null,"Income Tax. Taking 200 from the player.");
                player.takeMoney(200);
            }
            if(game_board[player.position].getName().equals("Luxury Tax"))
            {
                JOptionPane.showMessageDialog(null,"Income Tax. Taking 100 from the player.");
                player.takeMoney(100);
            }
            if(player.position == 30)
            {
                JOptionPane.showMessageDialog(null,"You are going to Jail.");
                player.goToJail();

            }
        }


    }


}

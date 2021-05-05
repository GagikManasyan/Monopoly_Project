package com.company;
import java.util.Scanner;

public class GameWindow {

    private static int turn = -1;
    private static void taketurns(int player_count)
    {
        turn += 1;
        if(turn > player_count - 1)
        {
            turn = 0;
        }
    }
    private static boolean GameOver()
    {
        return true;
    }
    private static Scanner inp = new Scanner(System.in);
    public static void main(String[] args)
    {

        System.out.print("Write number of players. Min 2, Max 4 - ");
        int player_count = inp.nextInt();
        Player [] players = new Player[player_count];
        if(player_count == 2)
        {
            System.out.print("Player 1 Write Name : ");
            String name1 = inp.next();
            System.out.print("Player 2 Write Name : ");
            String name2 = inp.next();
            players[0] = new Player(name1);
            players[1] = new Player(name2);
        }
        if(player_count == 3)
        {
            System.out.print("Player 1 Write Name : ");
            String name1 = inp.next();
            System.out.print("Player 2 Write Name : ");
            String name2 = inp.next();
            System.out.print("Player 3 Write Name : ");
            String name3 = inp.next();
            players[0] = new Player(name1);
            players[1] = new Player(name2);
            players[2] = new Player(name3);

        }
        if(player_count == 4)
        {
            System.out.print("Player 1 Write Name : ");
            String name1 = inp.next();
            System.out.print("Player 2 Write Name : ");
            String name2 = inp.next();
            System.out.print("Player 3 Write Name : ");
            String name3 = inp.next();
            System.out.print("Player 4 Write Name : ");
            String name4 = inp.next();
            players[0] = new Player(name1);
            players[1] = new Player(name2);
            players[2] = new Player(name3);
            players[3] = new Player(name4);
        }
        Game game = new Game();
        do
        {
            taketurns(player_count);
            game.allSet();
            if(players[turn].getHasSet() == true)
            {
                if(players[turn].getHas4Houses() == true)
                {
                    System.out.print(players[turn].getPlayerName() + " Do you wish do build a house or hotel ? : ");
                    String command = inp.next();
                    if(command.equals("hotel"))
                    {
                        game.addHotel(players[turn]);
                    }
                    if(command.equals("house"))
                    {
                        game.addHouse(players[turn]);
                    }
                }
                else
                {
                    System.out.print(players[turn].getPlayerName() + " Do you wish do build a house ? : ");
                    char command = inp.next().charAt(0);
                    if(command == 'y')
                    {
                        game.addHouse(players[turn]);
                    }
                }
            }
            String command = "";
            System.out.print(players[turn].getPlayerName() + " it's your turn type <throw> to throw the dice : ");
            command = inp.next();
            if(command.equals("throw"))
            {
                int dice = game.diceRoll();
                System.out.println("Dice : " + dice);
                game.Move(players[turn],dice);
                game.Feedback(players[turn]);
            }
        }
        while (GameOver() == true);






        /*Game game = new Game("a","b","c","d");
        int c = 0;
        *//*game.Shuffle();*//*
        do
        {
            c = c+1;
            game.Move();
        }
        while(c < 100);*/


    }
}

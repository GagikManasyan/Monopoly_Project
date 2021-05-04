package com.company;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game("a","b","c","d");
        int c = 0;
        /*game.Shuffle();*/
        do
        {
            c = c+1;
            game.Move();
        }
        while(c < 100);


    }
}

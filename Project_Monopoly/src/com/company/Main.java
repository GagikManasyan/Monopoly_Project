package com.company;

public class Main {

    public static void main(String[] args)
    {
        int c = 0;
        Game game = new Game("a","b","c","d");
        do
        {
            c = c+1;
            game.Feedback();
            game.Move();






        }
        while(c <= 100);


    }
}

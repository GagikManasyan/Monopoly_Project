package com.company;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game("a","b","c","d");
        do
        {
            game.Move();
        }
        while(game.gameOver() == false);


    }
}

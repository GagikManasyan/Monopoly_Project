package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends GameBoard implements ActionListener
{
    ///Game window
    private JFrame gamewindow;
    private JButton Throw;
    private JButton BuyHouse;
    private JButton BuyHotel;
    private JButton Sell;
    private JLabel playerinfo;
    private JLabel square;
    private Player [] players = LaunchWindow.getPlayers();
    private int turn = -1;
    private Game game = new Game(players[0]);
    public GameWindow ()
    {

        game.allSet();

        gamewindow = new JFrame();
        gamewindow.setSize(560,800);
        gamewindow.setLayout(null);
        gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamewindow.setResizable(false);
        gamewindow.setLocationRelativeTo(null);


        Throw = new JButton("Throw");
        Throw.setBounds(50,600, 200,50);
        Throw.setBackground(Color.WHITE);
        Throw.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        Throw.setFocusable(false);
        Throw.addActionListener(this);

        BuyHouse = new JButton("Buy House");
        BuyHouse.setBounds(300,600, 200,50);
        BuyHouse.setBackground(Color.WHITE);
        BuyHouse.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        BuyHouse.setFocusable(false);
        BuyHouse.addActionListener(e -> buyHouse(players[turn]));

        Sell = new JButton("Sell");
        Sell.setBounds(50,530, 200,50);
        Sell.setBackground(Color.WHITE);
        Sell.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        Sell.setFocusable(false);
        Sell.addActionListener(e -> Sell(players[turn]));

        BuyHotel = new JButton("Buy Hotel");
        BuyHotel.setBounds(300,530, 200,50);
        BuyHotel.setBackground(Color.WHITE);
        BuyHotel.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        BuyHotel.setFocusable(false);
        BuyHotel.addActionListener(e -> buyHotel(players[turn]));

        square = new JLabel();
        square.setBounds(55,50,450,200);
        square.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black,Color.black,Color.black));

        playerinfo = new JLabel();
        playerinfo.setBounds(80,75,400,40);
        playerinfo.setFont(new Font("Verdana", Font.BOLD, 45));


        gamewindow.add(playerinfo);
        gamewindow.add(Throw);
        gamewindow.add(BuyHouse);
        gamewindow.add(Sell);
        gamewindow.add(BuyHotel);
        gamewindow.add(square);





        gamewindow.setVisible(true);

        if(GameOver() != null)
        {
            JOptionPane.showMessageDialog(null, GameOver() + " You Won !");
            gamewindow.setVisible(false);
        }


    }
    private void taketurns()
    {
        int player_count = LaunchWindow.getPlayercount();
        turn += 1;
        if(turn > player_count - 1)
        {
            turn = 0;
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Throw)
        {
            taketurns();
            int dice_roll = game.diceRoll();
            playerinfo.setText(players[turn].getPlayerName() + ": " + players[turn].getPlayer_budget());
            game.Move(players[turn], dice_roll);
            game.Feedback(players[turn]);
            playerinfo.setText(players[turn].getPlayerName() + ": " + players[turn].getPlayer_budget());

        }
    }
    public void buyHouse (Player player)
    {
        game.addHouse(player);
        playerinfo.setText(players[turn].getPlayerName() + ": " + players[turn].getPlayer_budget());
    }
    public void buyHotel (Player player)
    {
        game.addHotel(player);
        playerinfo.setText(players[turn].getPlayerName() + ": " + players[turn].getPlayer_budget());
    }
    public void Sell (Player player)
    {
        game.Sell(player);
        playerinfo.setText(players[turn].getPlayerName() + ": " + players[turn].getPlayer_budget());
    }
    public String GameOver()
    {
        if (players.length == 2)
        {
            if(players[0].getPlayer_budget() > 0 && players[1].getPlayer_budget() <= 0)
            {
                return players[0].getPlayerName();
            }
            if(players[1].getPlayer_budget() > 0 && players[0].getPlayer_budget() <= 0)
            {
                return players[1].getPlayerName();
            }
        }
        if (players.length == 3)
        {
            if(players[0].getPlayer_budget() > 0 && players[1].getPlayer_budget() <= 0 && players[2].getPlayer_budget() <= 0)
            {
                return players[0].getPlayerName();
            }
            if(players[1].getPlayer_budget() > 0 && players[2].getPlayer_budget() <= 0 && players[0].getPlayer_budget() <= 0)
            {
                return players[1].getPlayerName();
            }
            if(players[2].getPlayer_budget() > 0 && players[1].getPlayer_budget() <= 0 && players[0].getPlayer_budget() <= 0)
            {
                return players[2].getPlayerName();
            }
        }
        if (players.length == 4)
        {
            if(players[0].getPlayer_budget() > 0 && players[1].getPlayer_budget() <= 0 && players[2].getPlayer_budget() <= 0 && players[3].getPlayer_budget() <= 0)
            {
                return players[0].getPlayerName();
            }
            if(players[1].getPlayer_budget() > 0 && players[2].getPlayer_budget() <= 0 && players[0].getPlayer_budget() <= 0 && players[3].getPlayer_budget() <= 0)
            {
                return players[1].getPlayerName();
            }
            if(players[2].getPlayer_budget() > 0 && players[1].getPlayer_budget() <= 0 && players[0].getPlayer_budget() <= 0 && players[3].getPlayer_budget() <= 0)
            {
                return players[2].getPlayerName();
            }
            if(players[3].getPlayer_budget() > 0 && players[2].getPlayer_budget() <= 0 && players[1].getPlayer_budget() <= 0 && players[1].getPlayer_budget() <= 0)
            {
                return players[3].getPlayerName();
            }
        }
        return null;
    }
}

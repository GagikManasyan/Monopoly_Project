package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LaunchWindow extends JFrame implements ActionListener
{
    JButton Start;
    JButton Exit;
    private static int playercount;
    protected static Player [] players;
    LaunchWindow ()
    {
        super("Monopoly");
        Start = new JButton("Start");
        Exit = new JButton("Exit");
        Start.setBounds(750,600,200,40);
        Start.setBackground(Color.WHITE);
        Start.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        Start.addActionListener(this);
        Start.setFocusable(false);
        Exit.setBounds(500,600,200,40);
        Exit.setBackground(Color.WHITE);
        Exit.setBorder(BorderFactory.createBevelBorder(2,Color.black,Color.black,Color.black,Color.black));
        Exit.addActionListener(e -> System.exit(0));
        Exit.setFocusable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
        {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\strai\\Desktop\\Java\\Monopoly_Project\\image\\image.png")))));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        this.setLayout(null);
        this.setResizable(false);
        this.pack();
        this.setSize(1500,800);
        this.add(Start);
        this.add(Exit);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource() == Start)
            {
                String pcount = JOptionPane.showInputDialog(null, "Pick the player count", "player count", JOptionPane.PLAIN_MESSAGE);
                if (pcount != null)
                {
                    playercount = Integer.parseInt(pcount);
                    if(playercount > 4)
                    {
                        JOptionPane.showMessageDialog(null, "This game is designed to play with 4 players.");
                    }
                    if(playercount == 1)
                    {
                        JOptionPane.showMessageDialog(null, "You cannot play alone !");

                    }
                    if(playercount == 2)
                    {
                        players = new Player[2];
                        players[0] = new Player();
                        players[1] = new Player();
                        String name1 = JOptionPane.showInputDialog(null, "Player 1. Write your name", "player 1", JOptionPane.PLAIN_MESSAGE);
                        if(name1 != null)
                        {
                            players[0].setPlayer_name(name1);
                            String name2 = JOptionPane.showInputDialog(null, "Player 2. Write your name", "player 2", JOptionPane.PLAIN_MESSAGE);
                            if(name2 != null)
                            {
                                players[1].setPlayer_name(name2);
                                dispose();
                                GameWindow window = new GameWindow();
                            }
                        }
                    }
                    if(playercount == 3)
                    {
                        players = new Player[3];
                        players[0] = new Player();
                        players[1] = new Player();
                        players[2] = new Player();
                        String name1 = JOptionPane.showInputDialog(null, "Player 1. Write your name", "player 1", JOptionPane.PLAIN_MESSAGE);
                        if(name1 != null)
                        {
                            players[0].setPlayer_name(name1);
                            String name2 = JOptionPane.showInputDialog(null, "Player 2. Write your name", "player 2", JOptionPane.PLAIN_MESSAGE);
                            if(name2 != null)
                            {
                                players[1].setPlayer_name(name2);
                                String name3 = JOptionPane.showInputDialog(null, "Player 3. Write your name", "player 3", JOptionPane.PLAIN_MESSAGE);
                                if(name3 != null)
                                {
                                    players[2].setPlayer_name(name3);
                                    dispose();
                                    GameWindow window = new GameWindow();
                                }
                            }
                        }
                    }
                    if(playercount == 4)
                    {
                        players = new Player[4];
                        players[0] = new Player();
                        players[1] = new Player();
                        players[2] = new Player();
                        players[3] = new Player();
                        String name1 = JOptionPane.showInputDialog(null, "Player 1. Write your name", "player 1", JOptionPane.PLAIN_MESSAGE);
                        if(name1 != null)
                        {
                            players[0].setPlayer_name(name1);
                            String name2 = JOptionPane.showInputDialog(null, "Player 2. Write your name", "player 2", JOptionPane.PLAIN_MESSAGE);
                            if(name2 != null)
                            {
                                players[1].setPlayer_name(name2);
                                String name3 = JOptionPane.showInputDialog(null, "Player 3. Write your name", "player 3", JOptionPane.PLAIN_MESSAGE);
                                if(name3 != null)
                                {
                                    players[2].setPlayer_name(name3);
                                    String name4 = JOptionPane.showInputDialog(null, "Player 4. Write your name", "player 4", JOptionPane.PLAIN_MESSAGE);
                                    if(name4 != null)
                                    {
                                        players[3].setPlayer_name(name4);
                                        dispose();
                                        GameWindow window = new GameWindow();

                                    }
                                }
                            }
                        }

                    }
                }
                else
                {

                }

            }
            }
    public static int getPlayercount() {
        return playercount;
    }
    public static Player[] getPlayers() {
        return players;
    }
}

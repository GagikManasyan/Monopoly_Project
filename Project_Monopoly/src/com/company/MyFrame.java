package com.company;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    MyFrame()
    {
        ImageIcon icon = new ImageIcon("image\\logo.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Monopoly");
        this.setSize(1500, 900);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

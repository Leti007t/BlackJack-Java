package com.github.Leti007t.Screen;

import javax.swing.*;

//sets the game window
public class Frame extends JFrame {
    Panel panel;
    public Frame(Panel panel){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        setVisible(true);
        setName("Blackjack");
        setTitle("Blackjack");
        add(panel);
        pack();
        setIconImage(panel.originalPokerchip.getImage());
    }
}

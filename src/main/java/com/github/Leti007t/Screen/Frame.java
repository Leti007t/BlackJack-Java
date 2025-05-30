package com.github.Leti007t.Screen;

import com.github.Leti007t.Console.Console;

import javax.swing.*;

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
    }
}

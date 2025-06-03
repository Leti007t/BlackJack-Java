package com.github.Leti007t.Console;

import com.github.Leti007t.Dealer.Cards;
import com.github.Leti007t.Dealer.Round;
import com.github.Leti007t.Screen.Panel;

//controls the start of a new blackjack round
// creates start and again buttons and adds the functions
public class GameManager {
    Panel panel;
    Round round;
    Cards cards;

    public GameManager(Panel panel, Round round, Cards cards){
        this.panel = panel;
        this.round = round;
        this.cards = cards;
    }

    public void startGame(){
        panel.createLogo();
        panel.createStartButton();
        panel.createAgainButton();


        panel.startButton.addActionListener(e -> {
            cards.shuffle();
            panel.startRound();
            round.startRound();
        });
        panel.againButton.addActionListener(e -> {
            cards.shuffle();
            panel.startRound();
            round.startRound();
        });
    }
}

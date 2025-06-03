package com.github.Leti007t.Dealer;


import com.github.Leti007t.Console.Console;
import com.github.Leti007t.Screen.Panel;

import javax.swing.*;

//manages the sequence and order of a single round
//also creates the playing buttons ("Ziehen"/"Halten")
//calculates the winner of a round
public class Round {

    Cards cards;
    Player.Player player;
    DealerBot dealerBot;
    Console console;
    Panel mypanel;
    Player.Bank bank;

    public Round (Cards cards, Player.Player player, DealerBot dealerBot, Console console, Panel panel, Player.Bank bank){
        this.cards=cards;
        this.player=player;
        this.dealerBot=dealerBot;
        this.console = console;
        this.mypanel = panel;
        this.bank = bank;
    }

    public void startRound() {
        player.startRound();
        dealerBot.startRound();
        if(dealerBot.isPlaying && player.isPlaying){ //play round if there is no blackjack before

            mypanel.hitButton.addActionListener(e -> {
                if ( player.isPlaying){
                    player.playRound();
                    if (!(player.isAlive)){// if the players hand is over 21 he loses
                        bank.loses++;
                        console.printAnotherRound();
                        console.printStats(bank.wins, bank.loses);
                    }
                }
            });

            if(player.isPlaying){ //player hand value <21 and no blackjack

                mypanel.holdButton.addActionListener(e -> {
                    if (dealerBot.isPlaying){
                        player.isPlaying = false;
                        dealerBot.playRound();
                        if (!(dealerBot.isAlive)){
                            bank.wins++;
                            console.printAnotherRound();
                            console.printStats(bank.wins, bank.loses);
                        }
                        endRound();
                    }
                });
            }
        }

        else if (player.isPlaying){ //if player has no blackjack but dealer, the player loses
            bank.loses++;
            console.printStats(bank.wins, bank.loses);
        }
        else if (dealerBot.isPlaying) { // if player has a blackjack and dealer has no blackjack, the player wins
            bank.wins++;
            console.printStats(bank.wins, bank.loses);
        }
    }

    private void endRound(){ //determines who won if player and dealer hand values are <21 and there is no blackjack
        if (dealerBot.isAlive && player.isAlive){
            if (player.value>dealerBot.value){
                console.printPlayerWin();
                bank.wins++;
            }
            if (player.value<dealerBot.value){
                console.printDealerwin();
                bank.loses++;
            }
            if (player.value==dealerBot.value){
                console.printDraw();
            }
            console.printAnotherRound();
            console.printStats(bank.wins, bank.loses);

        }
    }
}



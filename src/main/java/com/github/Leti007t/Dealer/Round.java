package com.github.Leti007t.Dealer;


import com.github.Leti007t.Console.Console;
import com.github.Leti007t.Screen.Panel;

import javax.swing.*;


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
        System.out.println();//in frontend unnötig
        if(dealerBot.isPlaying && player.isPlaying){

            mypanel.hitButton.addActionListener(e -> {
                if (dealerBot.isPlaying && player.isPlaying){
                    player.playRound();
                    if (!(player.isAlive)){
                        bank.loses++;
                        console.printAnotherRound(); //wenn player überkauft, kommt nochmal button
                        console.printStats(bank.wins, bank.loses);
                    }
                }
            });

            if(player.isPlaying){

                mypanel.holdButton.addActionListener(e -> {
                    if (dealerBot.isPlaying && player.isPlaying){
                        player.isPlaying = false;
                        dealerBot.playRound();
                        if (!(dealerBot.isAlive)){
                            bank.wins++;
                            console.printAnotherRound(); //wenn dealer überkauft, kommt nochmal button
                            console.printStats(bank.wins, bank.loses);
                        }
                        endRound();
                    }
                });
            }
        }

        else if (player.isPlaying){
            bank.loses++;
            console.printStats(bank.wins, bank.loses);
        }
        else if (dealerBot.isPlaying) {
            bank.wins++;
            console.printStats(bank.wins, bank.loses);
        }
    }

    private void endRound(){
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



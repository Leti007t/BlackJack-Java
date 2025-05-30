package com.github.Leti007t.Console;




import com.github.Leti007t.Dealer.Card;
import com.github.Leti007t.Screen.Panel;

import java.util.ArrayList;


public class Console {
    public Panel mypanel;


    public Console(Panel panel) {

        this.mypanel = panel;
    }

    //Alle output Methoden:

    //Round
    public void printAnotherRound(){
        mypanel.showAgainButton();
        System.out.println("noch eine runde?");
    }
    public void printStats(int wins, int loses){
        mypanel.createStats(wins, loses);
    }
    public void printPlayerWin(){
        System.out.println();
        System.out.println("Player gewinnt");
        mypanel.createWin();
    }
    public void printDealerwin(){
        System.out.println();
        System.out.println("Dealer gewinnt");
        mypanel.createLose();
    }
    public void printDraw(){
        System.out.println();
        System.out.println("Unentschieden");
        mypanel.createDraw();
    }
    //Dealer
    public void printHiddenCard(){
        System.out.println("Verdeckte Karte");
        mypanel.createHiddenCard();
    }
    public void showHiddenCard(Card card){
        System.out.println("Verdeckte Karte: " + card);
        mypanel.revealHiddenCard(card);
    }
    //Player & Dealer
    public void printCard(ArrayList<Card> hand){
        mypanel.createCard(hand);
    }

    public void printBlackJack(String player){
        mypanel.createBlackJack();
        if(player.equals("Player")){
            mypanel.createWin();
        }
        else {mypanel.createLose();}
        printAnotherRound();
    }
}


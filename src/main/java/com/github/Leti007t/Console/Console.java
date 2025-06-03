package com.github.Leti007t.Console;




import com.github.Leti007t.Dealer.Card;
import com.github.Leti007t.Screen.Panel;

import java.util.ArrayList;

//link from backend code to class panel
public class Console {
    public Panel mypanel;


    public Console(Panel panel) {

        this.mypanel = panel;
    }

    //Alle output Methoden:

    //Round
    public void printAnotherRound(){
        mypanel.showAgainButton();
    }
    public void printStats(int wins, int loses){
        mypanel.createStats(wins, loses);
    }
    public void printPlayerWin(){
        mypanel.createWin();
    }
    public void printDealerwin(){
        mypanel.createLose();
    }
    public void printDraw(){
        mypanel.createDraw();
    }
    //Dealer
    public void printHiddenCard(){
        mypanel.createHiddenCard();
    }
    public void showHiddenCard(Card card){
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


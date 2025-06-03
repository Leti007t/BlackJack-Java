package com.github.Leti007t.Dealer;


import com.github.Leti007t.Console.Console;

//bot player class
public class DealerBot extends Player.Player {


    public DealerBot(Cards cards, Console console) {
        super(cards, console);
        name="Dealer";
    }

    @Override
    public void playRound(){
        console.showHiddenCard(hand.get(1));
        while (true) {

            if (value<17) {
                newCard();
                if(value>21){
                    console.printPlayerWin();
                    isAlive = false;
                    break;
                }
            }
            if (value >= 17){
                break;
            }
        }
    }

    @Override
    protected void getCard (){
        Card card = cards.randomCard();
        card.yPosition= 10;
        hand.add(card);
    }
    @Override
    protected void newCard(){
        getCard();
        getHandValue();
        if(hand.size()==2){
            getBlackJack();
        }
        if(isPlaying){

            if(!(hand.size()==2)){
                console.printCard(hand);
            }
            if(hand.size()==2){
                console.printHiddenCard();
            }
        }
    }
    @Override
    protected void getBlackJack(){
        if(value== 21){
            console.printCard(hand);
            console.printBlackJack("Dealer");
            isPlaying = false;
        }
    }

}












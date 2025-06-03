package Player;




import com.github.Leti007t.Console.Console;
import com.github.Leti007t.Dealer.Card;
import com.github.Leti007t.Dealer.Cards;

import java.util.ArrayList;

//player class
public class Player {
    public int value;
    public boolean isPlaying;
    public boolean isAlive;
    public ArrayList<Card> hand = new ArrayList<Card>();
    public Console console;
    protected Cards cards;
    protected String name;
    private int aces = 0;

    public Player(Cards cards, Console console){
        this.cards=cards;
        this.console = console;
        name= "Player";
    }

    public void startRound(){
        hand.clear();
        isPlaying=true;
        isAlive = true;
        newCard();
        newCard();
    }

    public void playRound(){
        newCard();
        if(value>21){
            console.printDealerwin();
            isAlive=false;
            isPlaying = false;
        }
    }

    protected void getCard (){ //Auf Spieler
        Card card = cards.randomCard();
        card.yPosition= 483;
        hand.add(card);
        console.printCard(hand);
    }

    protected int getCardValue(int i){
        if (i<=10 && i>1){
            return i;
        }
        else if (i>10) {
            return 10;
        }
        else {
            if (value + 11 > 21 || value +11 +(aces-1) >21){
                return 1;
            }
            else{
                return 11;
            }
        }
    }
    protected void getHandValue(){
        value=0;
        aces = 0;
        for (Card card : hand) {
            if (card.number > 1) {
                value += getCardValue(card.number);
            }
            else {
                aces++;
            }
        }
        for (int j= 0; j<aces; j++){
            value += getCardValue(1);
        }
    }
    protected void newCard(){
        getCard();
        getHandValue();

        if(hand.size()==2){
            getBlackJack();
        }
    }
    protected void getBlackJack(){
        if(value== 21){
        console.printBlackJack("Player");
        isPlaying = false;
        }
    }
}

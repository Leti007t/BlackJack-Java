package com.github.Leti007t.Dealer;






import java.util.ArrayList;
import java.util.Random;

//methods to create the playing cards and to pick a random card
public class Cards {
    Random random= new Random();
    public ArrayList<Card> cards = new ArrayList<Card>();
    private String [] cardnames = new String[14];

    public Cards(){
    }

    public void shuffle (){
        cards.clear();

        for (int j=1; j<5; j++){ // Karo=1, Piek=2, Kreuz=3, Herz=4
            for (int i = 1; i<14; i++){
                Card card;
                cards.add(card = new Card(i, j));
            }
        }
    }

    public Card randomCard(){
        int i = random.nextInt(1,cards.size());
        Card tempCard = cards.get(i-1);
        cards.remove(i-1);
        return tempCard;
    }

}

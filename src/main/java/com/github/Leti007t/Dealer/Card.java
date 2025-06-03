package com.github.Leti007t.Dealer;


//every card is an instance of this class with all the important values
public class Card {
    public int number;
    public int color;
    public int xPosition;
    public int yPosition;
    public String cardId;
    public Card(int number, int color){
        this.number = number;
        this.color = color;
        this.cardId = color +""+ number;
    }
}

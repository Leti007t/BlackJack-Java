package com.github.Leti007t.Dealer;

import javax.swing.*;

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

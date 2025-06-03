package com.github.Leti007t;
import Player.Bank;
import com.github.Leti007t.Console.Console;
import com.github.Leti007t.Console.GameManager;
import com.github.Leti007t.Screen.Frame;
import com.github.Leti007t.Dealer.Cards;
import com.github.Leti007t.Dealer.DealerBot;
import com.github.Leti007t.Dealer.Round;
import com.github.Leti007t.Screen.Panel;

import javax.swing.*;

// manages all the class relations and creates all instances
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Cards cards = new Cards();
        Panel panel = new Panel(cards);
        Frame frame = new Frame(panel);
        Console console = new Console(panel);
        Player.Player player = new Player.Player(cards, console);
        DealerBot dealerBot = new DealerBot(cards, console);
        Round round = new Round(cards, player, dealerBot, console, panel, bank);
        GameManager gameManager = new GameManager(panel, round, cards);

        gameManager.startGame();
    }
}
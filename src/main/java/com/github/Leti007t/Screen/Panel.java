package com.github.Leti007t.Screen;
import com.github.Leti007t.Dealer.Card;
import com.github.Leti007t.Dealer.Cards;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Panel extends JPanel {
    private Image originalBackground = new ImageIcon(getClass().getResource("/images/background.png")).getImage();
    private ImageIcon ziehenPokerChip = new ImageIcon(getClass().getResource("/images/ziehenPokerchip.png"));
    private ImageIcon haltenPokerChip = new ImageIcon(getClass().getResource("/images/haltenPokerchip.png"));
    private ImageIcon originalHiddenCard = new ImageIcon(getClass().getResource("/images/hiddenCard.png"));
    private ImageIcon buttonAgain = new ImageIcon(getClass().getResource("/images/buttonNochmal.png"));
    private ImageIcon buttonStart = new ImageIcon(getClass().getResource("/images/buttonStart.png"));
    private ImageIcon originalLogo = new ImageIcon(getClass().getResource("/images/logo.png"));
    private ImageIcon originalWin = new ImageIcon(getClass().getResource("/images/win.png"));
    private ImageIcon originalLose = new ImageIcon(getClass().getResource("/images/lose.png"));
    private ImageIcon originalDraw = new ImageIcon(getClass().getResource("/images/draw.png"));
    private ImageIcon originalBlackjack = new ImageIcon(getClass().getResource("/images/blackJack.png"));
    private ImageIcon originalPokerchip = new ImageIcon(getClass().getResource("/images/pokerchip.png"));

    public Cards cards;

    private JLabel hiddenCard;
    private ArrayList<JLabel> playerCards = new ArrayList<>();
    private ArrayList<JLabel> dealerCards = new ArrayList<>();

    public JButton hitButton;
    public JButton holdButton;
    public JButton againButton;
    public JButton startButton;


    public Panel(Cards cards){
    setLayout(null);
    this.cards = cards;
    }

    @Override // methode zum Festlegen der Panel-Maße
    public Dimension getPreferredSize() {
        return new Dimension(1024, 720);
    }

    @Override //methode zum Aufrufen eines Konstruktors, der ein gewisses Bild malt
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(originalBackground, 0, 0, 1024, 720, this);
    }

    private void refresh(){
        revalidate();
        repaint();
    }

    //Bild wird zu skaliertem Bild mit scaled(Bild, width, height)
    private ImageIcon scaled (ImageIcon icon, int width, int height){
        Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    private void removeBox(JButton button){
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }


    public void createStartButton(){
        System.out.println("test");
        startButton = new JButton(scaled(buttonStart, 175, 175));
        startButton.setBounds(452, 300, 120, 120);
        removeBox(startButton);
        add(startButton);
        refresh();
    }

    public void createLogo(){
        JLabel logo = new JLabel(scaled(originalLogo, 500,500 ));
        logo.setBounds(262, -100, 500, 500);
        add(logo);
        refresh();
    }

    public void createAgainButton(){
        againButton = new JButton(scaled(buttonAgain, 175, 175));
        againButton.setBounds(452, 300, 120, 120);
        removeBox(againButton);
        againButton.setVisible(false);
        againButton.setEnabled(false);
        add(againButton);
    }

    public void showAgainButton(){
        againButton.setEnabled(true);
        againButton.setVisible(true);
        remove(hitButton);
        remove(holdButton);
        refresh();
    }

    public void createStats(int win, int loses){
        String wins = "Siege: " + win;
        String ratio = "S/N: " +  (win - loses);

        JLabel showWins = new JLabel(wins, scaled(originalPokerchip, 175, 175), JLabel.CENTER);
        showWins.setBounds(256, 300, 120, 120);
        showWins.setFont(new Font("Arial", Font.BOLD, 18));
        showWins.setForeground(Color.WHITE);
        showWins.setHorizontalTextPosition(JLabel.CENTER);
        showWins.setVerticalTextPosition(JLabel.CENTER);
        add(showWins);

        JLabel showRatio = new JLabel(ratio, scaled(originalPokerchip, 175, 175), JLabel.CENTER);
        showRatio.setBounds(648, 300, 120, 120);
        showRatio.setFont(new Font("Arial", Font.BOLD, 18));
        showRatio.setForeground(Color.WHITE);
        showRatio.setHorizontalTextPosition(JLabel.CENTER);
        showRatio.setVerticalTextPosition(JLabel.CENTER);
        add(showRatio);
    }

    public void startRound(){
        for (Component comp : getComponents()) { //entfernt alle außer den again Button
            if (comp != againButton) {
                remove(comp);
            }
        }
        againButton.setVisible(false);
        againButton.setEnabled(false); // lässt den again Button verschwinden, ohne seine funktion zu löschen
        createPlayButtons();
        playerCards.clear();
        dealerCards.clear();
        refresh();
    }

    private void createPlayButtons(){
        hitButton = new JButton(scaled(ziehenPokerChip, 175, 175));
        hitButton.setBounds(256, 300, 120, 120);
        removeBox(hitButton);
        add(hitButton);

        holdButton = new JButton(scaled(haltenPokerChip, 175, 175));
        holdButton.setBounds(648, 300, 120, 120);
        removeBox(holdButton);
        add(holdButton);
    }

    public void createCard(ArrayList<Card> hand){
        Card card = hand.get(hand.size()-1);

        if(hand.size() <= 6){
            int standartCardWidth=159;
            int standartCardHeight= (int) (standartCardWidth*1.425);
            int i= hand.size()-1;
            card.xPosition = i*159 + (i+1)*10;
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/cards/" + card.cardId + ".png" ));
            JLabel tempCard = new JLabel(scaled(icon, standartCardWidth,standartCardHeight ));
            tempCard.setBounds(card.xPosition, card.yPosition, standartCardWidth, standartCardHeight);

            if (card.yPosition == 10){ //dealer
                dealerCards.add(tempCard);
            }
            else { //player
                playerCards.add(tempCard);
            }
            add(tempCard);
            refresh();
        }

        else{
            int y;
            int cardWidth= (int) (954/hand.size());
            int cardHeight= (int) (cardWidth*1.425);

            if (card.yPosition == 10){
                for (JLabel label : dealerCards){
                    remove(label);
                }
                dealerCards.clear();
                y=10;
            }
            else {
                for (JLabel label : playerCards){
                    remove(label);
                }
                playerCards.clear();
                y = 720 - (cardHeight+10);
            }

                for (int i=0; i<hand.size(); i++){
                    hand.get(i).xPosition = i*cardWidth + (i+1)*10;
                    hand.get(i).yPosition = y;
                    ImageIcon icon = new ImageIcon(getClass().getResource("/images/cards/" + hand.get(i).cardId + ".png" ));
                    JLabel tempCard = new JLabel(scaled(icon, cardWidth, cardHeight));
                    tempCard.setBounds(hand.get(i).xPosition, hand.get(i).yPosition, cardWidth, cardHeight);
                    add(tempCard);
                    if (y == 10){ //dealer
                        dealerCards.add(tempCard);
                    }
                    else { //player
                        playerCards.add(tempCard);
                    }
                }
                refresh();
        }

    }

    public void createHiddenCard(){
        hiddenCard = new JLabel(scaled(originalHiddenCard, 159,(int) (159*1.425) ));
        hiddenCard.setBounds(179, 10, 159, (int) (159*1.425));
        add(hiddenCard);
        refresh();
    }

    public void revealHiddenCard(Card card){
        remove(hiddenCard);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/cards/" + card.cardId + ".png" ));
        JLabel tempCard = new JLabel(scaled(icon, 159,(int) (159*1.425) ));
        tempCard.setBounds(179, 10, 159, (int) (159*1.425));
        dealerCards.add(tempCard);
        add(tempCard);
        refresh();
    }

    public void createWin(){
        JLabel win = new JLabel(scaled(originalWin, 120,120 ));
        win.setBounds(75, 300, 120, 120);
        add(win);
        refresh();
    }

    public void createLose(){
        JLabel lose = new JLabel(scaled(originalLose, 120,120 ));
        lose.setBounds(75, 300, 120, 120);
        add(lose);
        refresh();
    }

    public void createDraw(){
        JLabel draw = new JLabel(scaled(originalDraw, 120,120 ));
        draw.setBounds(75, 300, 120, 120);
        add(draw);
        refresh();
    }

    public void createBlackJack(){
        JLabel blackJack = new JLabel(scaled(originalBlackjack, 120,120 ));
        blackJack.setBounds(829, 300, 120, 120);
        add(blackJack);
        refresh();
    }

}

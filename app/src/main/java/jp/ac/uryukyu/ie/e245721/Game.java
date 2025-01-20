package jp.ac.uryukyu.ie.e245721;


import java.util.ArrayList;

/**
 * ゲームクラス。ブラックジャックのロジックを提供する。
 */
public class Game {
    private final Deck deck = new Deck();
    private final ArrayList<Card> playerHand = new ArrayList<>();
    private final ArrayList<Card> dealerHand = new ArrayList<>();

    public void start() {
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        dealerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    public int calculateHandValue(ArrayList<Card> hand) {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) aceCount++;
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public String playerTurn() {
        return "Player hand: " + playerHand + " Value: " + calculateHandValue(playerHand);
    }

    public String dealerTurn() {
        return "Dealer hand: " + dealerHand + " Value: " + calculateHandValue(dealerHand);
    }

    public String determineWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (playerValue > 21) return "Player busts! Dealer wins!";
        if (dealerValue > 21) return "Dealer busts! Player wins!";
        if (playerValue > dealerValue) return "Player wins!";
        if (dealerValue > playerValue) return "Dealer wins!";
        return "It's a tie!";
    }

    public void hit() {
        playerHand.add(deck.draw());
    }

    public void dealerPlay() {
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(deck.draw());
        }
    }
}

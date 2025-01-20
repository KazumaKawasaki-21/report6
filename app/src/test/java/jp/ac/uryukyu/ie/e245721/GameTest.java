package jp.ac.uryukyu.ie.e245721;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testCalculateHandValue() {
        Game game = new Game();
        Deck deck = new Deck();
        Card card1 = new Card("Hearts", "10", 10);
        Card card2 = new Card("Diamonds", "Ace", 11);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);

        int value = game.calculateHandValue(hand);
        assertEquals(21, value);
    }
}


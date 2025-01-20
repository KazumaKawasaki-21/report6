package jp.ac.uryukyu.ie.e245721;

import java.util.ArrayList;
import java.util.Collections;

/**
 * トランプのデッキを表すクラス。
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * コンストラクタ。52枚のカードを作成し、デッキをシャッフル。
     */
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; // J, Q, K = 10, A = 11

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }
        shuffle();
    }

    /**
     * デッキをシャッフル。
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * デッキからカードを1枚引く。
     * @return 引いたカード
     */
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck!");
        }
        return cards.remove(0);
    }

    /**
     * 残りのカード枚数を取得。
     * @return 残りのカード枚数
     */
    public int size() {
        return cards.size();
    }
}

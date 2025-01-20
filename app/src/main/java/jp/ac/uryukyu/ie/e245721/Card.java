package jp.ac.uryukyu.ie.e245721;


/**
 * カードクラス。1枚のカードの情報を保持する。
 */
public class Card {
    private final String suit;
    private final String rank;
    private final int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + " " + rank;
    }
}


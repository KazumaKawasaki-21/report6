package jp.ac.uryukyu.ie.e245721;


/**
 * トランプのカードを表すクラス。
 */
public class Card {
    private String suit; // カードのスート (ハート, ダイヤ, スペード, クラブ)
    private String rank; // カードのランク (2-10, J, Q, K, A)
    private int value;   // カードの点数

    /**
     * コンストラクタ。
     * @param suit スート
     * @param rank ランク
     * @param value 点数
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * カードのスートを取得。
     * @return スート
     */
    public String getSuit() {
        return suit;
    }

    /**
     * カードのランクを取得。
     * @return ランク
     */
    public String getRank() {
        return rank;
    }

    /**
     * カードの点数を取得。
     * @return 点数
     */
    public int getValue() {
        return value;
    }

    /**
     * カードの文字列表現を返す。
     * @return カードのスートとランク
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

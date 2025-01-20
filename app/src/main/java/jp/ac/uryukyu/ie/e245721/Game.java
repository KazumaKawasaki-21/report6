package jp.ac.uryukyu.ie.e245721;


import java.util.ArrayList;

/**
 * ゲームのロジックを管理するクラス。
 */
public class Game {
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;
    private Deck deck;

    /**
     * コンストラクタ。プレイヤーとディーラーの手札を初期化し、デッキを準備します。
     */
    public Game() {
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        deck = new Deck();
    }

    /**
     * ゲームの開始時にカードを配る。
     */
    public void start() {
        playerHand.add(deck.draw());
        playerHand.add(deck.draw());
        dealerHand.add(deck.draw());
    }

    /**
     * プレイヤーがカードを引く。
     */
    public void hit() {
        playerHand.add(deck.draw());
    }

    /**
     * ディーラーのターンでカードを引く。
     */
    public void dealerPlay() {
        while (calculateHandValue(dealerHand) < 17) {
            dealerHand.add(deck.draw());
        }
    }

    /**
     * プレイヤーの手札を返す。
     * @return プレイヤーの手札。
     */
    public ArrayList<Card> playerTurn() {
        return playerHand;
    }

    /**
     * ディーラーの手札を返す。
     * @return ディーラーの手札。
     */
    public ArrayList<Card> dealerTurn() {
        return dealerHand;
    }

    /**
     * 手札の合計値を計算する。
     * @param hand 手札のリスト。
     * @return 手札の合計値。
     */
    public int calculateHandValue(ArrayList<Card> hand) {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    /**
     * 勝敗を判定する。
     * @return 勝敗の結果を文字列で返す。
     */
    public String determineWinner() {
        int playerValue = calculateHandValue(playerHand);
        int dealerValue = calculateHandValue(dealerHand);

        if (playerValue > 21) {
            return "Dealer wins!";
        } else if (dealerValue > 21 || playerValue > dealerValue) {
            return "Player wins!";
        } else if (playerValue < dealerValue) {
            return "Dealer wins!";
        } else {
            return "It's a tie!";
        }
    }
}

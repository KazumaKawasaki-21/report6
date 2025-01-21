package jp.ac.uryukyu.ie.e245721;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Player: " + game.playerTurn());
            System.out.println("Dealer shows: " + game.dealerTurn().get(0)); // ディーラーの1枚目だけ表示

            while (true) {
                System.out.println(">> Hit or Stand (h/s)?");
                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("h")) {
                    game.hit();
                    System.out.println("Player: " + game.playerTurn());
                    if (game.calculateHandValue(game.playerTurn()) > 21) {
                        System.out.println("Player busts!");
                        break;
                    }
                } else if (action.equalsIgnoreCase("s")) {
                    System.out.println("Player stands.");
                    break;
                }
            }
        } finally {
            scanner.close(); // Scannerを確実に閉じる
        }
    }
}

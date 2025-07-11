package org.blackjack.services;

import org.blackjack.models.Nominations.PlayerActions;
import org.blackjack.models.objects.Hand;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showHand(String owner, Hand hand, int points) {
        System.out.println(owner + " cards -> " + hand);
        System.out.println(owner + " points -> " + points);
    }

    public PlayerActions askUserAction() {
        System.out.println("Choose your next action:");
        System.out.println("0 -> draw | 1 -> stand");
        int input = scanner.nextInt();
        return PlayerActions.fromInt(input);
    }

    public void showGameEnd(int playerPoints, int dealerPoints) {
        System.out.println("Game ended");
        System.out.println("Player had: " + playerPoints);
        System.out.println("Dealer had: " + dealerPoints);
        scanner.close();
    }
}

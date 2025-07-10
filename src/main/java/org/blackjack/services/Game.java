package org.blackjack.services;

import org.blackjack.models.Nominations.PlayerActions;
import org.blackjack.models.objects.Deck;
import org.blackjack.models.objects.Hand;
import org.blackjack.models.participants.Dealer;
import org.blackjack.models.participants.Player;
import org.blackjack.utils.PointsCounter;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public void StartGame() {
        initValues();
        drawInitialCards();
        displayCurrentData();
    }

    public void endGame() {
        System.out.println("Game ended");
        if (isPlayerBusted()) {
            System.out.println("You've lost");
            System.out.println("You have " + PointsCounter.getCurrentAmountOfPoints(player.getHand()) + " points");
            System.out.println("Dealer had " + PointsCounter.getCurrentAmountOfPoints(dealer.getHand()) + " points");
        } else {
            System.out.println("You've won!");
            System.out.println("You have " + PointsCounter.getCurrentAmountOfPoints(player.getHand()) + " points");
            System.out.println("Dealer had " + PointsCounter.getCurrentAmountOfPoints(dealer.getHand()) + " points");
            scanner.close();
        }
    }

    private void initValues() {
        this.deck = new Deck();
        this.player = new Player(new Hand(new ArrayList<>()), 0);
        this.dealer = new Dealer(new Hand(new ArrayList<>()), 0);
    }

    private void drawInitialCards() {
        player.getHand().getCards().add(deck.removeCard());
        player.getHand().getCards().add(deck.removeCard());
    }

    private void displayCurrentData() {
        System.out.println("Your current cards are -> " + player.getHand().toString());
        System.out.printf("current amount of points -> " + PointsCounter.getCurrentAmountOfPoints(player.getHand()) + "%n");
        System.out.println("Please choose the next action: ");
        System.out.println("0 -> draw // 1 - stand");
    }

    public PlayerActions receiveUserAction() {
        int userInput = scanner.nextInt();
        return PlayerActions.fromInt(userInput);
    }

    public boolean isPlayerBusted() {
        return 22 <= PointsCounter.getCurrentAmountOfPoints(player.getHand());
    }

//    public void performUserAction(PlayerActions action) {
//        switch (action) {
//            case DRAW ->
//                    player.getHand().getCards().add(deck.removeCard());
//            case STAND ->
//        }
//    }



}

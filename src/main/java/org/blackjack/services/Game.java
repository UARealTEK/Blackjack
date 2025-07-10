package org.blackjack.services;

import org.blackjack.models.objects.Deck;
import org.blackjack.models.objects.Hand;
import org.blackjack.models.participants.Dealer;
import org.blackjack.models.participants.Player;

import java.util.ArrayList;

public class Game {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public void StartGame() {
        initValues();
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


}

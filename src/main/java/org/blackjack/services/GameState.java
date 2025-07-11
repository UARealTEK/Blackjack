package org.blackjack.services;

import lombok.Getter;
import lombok.Setter;
import org.blackjack.models.objects.Deck;
import org.blackjack.models.participants.Dealer;
import org.blackjack.models.participants.Player;

@Getter
@Setter
public class GameState {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private boolean gameEnded;

    public GameState(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.gameEnded = false;
    }
}
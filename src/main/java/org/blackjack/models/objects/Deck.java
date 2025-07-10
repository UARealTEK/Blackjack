package org.blackjack.models.objects;

import lombok.Getter;
import org.blackjack.models.Nominations.Rank;
import org.blackjack.models.Nominations.Suit;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    @Getter
    private static final int totalCardCount = 52;
    @Getter
    private int currentCardCount;
    private final ArrayList<Card> cards = new ArrayList<>();


    public Deck() {
        fillDeck();
        shuffleDeck();
        currentCardCount = totalCardCount;
    }


    private void fillDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank,suit));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card removeCard() {
        if (currentCardCount > 0) {
            currentCardCount--;
            return cards.removeFirst();
        } else throw new IllegalStateException("No cards left in the deck!");
    }

}

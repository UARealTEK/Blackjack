package org.blackjack.models.objects;

import lombok.ToString;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder hand = new StringBuilder();
        for (Card card : cards) {
            hand.append(card).append(" ");
        }

        return hand.toString().trim();
    }
}

package org.blackjack.models.objects;

import java.util.ArrayList;

public record Hand(ArrayList<Card> cards) {

    @Override
    public String toString() {
        StringBuilder hand = new StringBuilder();
        for (Card card : cards) {
            hand.append(card).append(" ");
        }

        return hand.toString().trim();
    }
}

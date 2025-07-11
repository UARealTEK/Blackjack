package org.blackjack.models.Nominations;

import lombok.Getter;

@Getter
public enum Suit {

    SPADES("♠"),
    DIAMONDS("♦"),
    HEARTS("♥"),
    CLUBS("♣");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

}

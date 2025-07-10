package org.blackjack.models.objects;

import lombok.Getter;
import org.blackjack.models.Nominations.Rank;
import org.blackjack.models.Nominations.Suit;

@Getter
public class Card {

    @Getter
    private final Rank rank;
    @Getter
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return (rank.getRank()) + suit.getSuit();
    }
}

package org.blackjack.models.objects;

import lombok.Getter;
import org.blackjack.models.Nominations.Rank;
import org.blackjack.models.Nominations.Suit;

public record Card(@Getter Rank rank, @Getter Suit suit) {

    @Override
    public String toString() {
        return (rank.name()) + suit.getSuit();
    }
}

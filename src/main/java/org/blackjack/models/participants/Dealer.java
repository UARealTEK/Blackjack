package org.blackjack.models.participants;

import lombok.Getter;
import org.blackjack.models.objects.Hand;

public class Dealer extends Participant {
    @Getter
    private Hand hand;
    @Getter
    private int currentPointsAmount;

    public Dealer(Hand hand, int currentPointsAmount) {
        super(hand, currentPointsAmount);
    }
}

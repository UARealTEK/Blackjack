package org.blackjack.models.participants;

import lombok.Getter;
import org.blackjack.models.objects.Hand;

public abstract class Participant {

    @Getter
    private Hand hand;
    @Getter
    private int currentPointsAmount;

    public Participant(Hand hand, int currentPointsAmount) {
        this.hand = hand;
        this.currentPointsAmount = currentPointsAmount;
    }

}

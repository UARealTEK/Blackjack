package org.blackjack.models.participants;

import org.blackjack.models.objects.Hand;

public abstract class Participant {

    private Hand hand;
    private int currentPointsAmount;

    public Participant(Hand hand, int currentPointsAmount) {
        this.hand = hand;
        this.currentPointsAmount = currentPointsAmount;
    }
}

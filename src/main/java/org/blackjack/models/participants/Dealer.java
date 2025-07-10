package org.blackjack.models.participants;

import lombok.Getter;
import org.blackjack.models.objects.Hand;

public class Dealer extends Participant {

    public Dealer(Hand hand, int currentPointsAmount) {
        super(hand, currentPointsAmount);
    }
}

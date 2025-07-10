package org.blackjack.models.participants;

import lombok.Getter;
import org.blackjack.models.objects.Hand;

public class Player extends Participant {

    public Player(Hand hand, int currentPointsAmount) {
        super(hand, currentPointsAmount);
    }

}

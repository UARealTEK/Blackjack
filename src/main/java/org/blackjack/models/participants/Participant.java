package org.blackjack.models.participants;

import lombok.Getter;
import org.blackjack.models.objects.Hand;

public abstract class Participant {

    @Getter
    private Hand hand;

    public Participant(Hand hand) {
        this.hand = hand;
    }

}

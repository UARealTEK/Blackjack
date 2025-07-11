package org.blackjack.utils;

import org.blackjack.models.participants.Participant;

public class PointsCounter {

    public static <T extends Participant> int getPlayerPoints(T participant) {
        return participant.getHand().cards().stream().mapToInt(card -> card.rank().getRank()).sum();
    }
}

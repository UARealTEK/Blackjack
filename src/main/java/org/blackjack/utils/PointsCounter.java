package org.blackjack.utils;

import org.blackjack.models.objects.Card;
import org.blackjack.models.objects.Hand;

public class PointsCounter {

    public static int getCurrentAmountOfPoints(Hand hand) {
        return hand.getCards().stream().mapToInt(card -> card.getRank().getRank()).sum();
    }
}

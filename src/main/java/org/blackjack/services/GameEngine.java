package org.blackjack.services;

import org.blackjack.models.Nominations.PlayerActions;
import org.blackjack.models.objects.Card;
import org.blackjack.models.participants.Participant;

import static org.blackjack.utils.PointsCounter.getPlayerPoints;

public class GameEngine {
    private final GameState state;
    private final ConsoleUI ui;

    public GameEngine(GameState state, ConsoleUI ui) {
        this.state = state;
        this.ui = ui;
    }

    public void startGame() {
        drawCard(state.getPlayer());
        drawCard(state.getPlayer());
        showPlayerStatus();
        checkInitialWinOrBust();
    }

    public void performUserAction(PlayerActions action) {
        switch (action) {
            case DRAW -> {
                drawCard(state.getPlayer());
                showPlayerStatus();
                checkIfBusted();
            }
            case STAND -> drawDealer();
        }
    }

    private void showPlayerStatus() {
        ui.showHand("Your", state.getPlayer().getHand(), getPlayerPoints(state.getPlayer()));
    }

    private void checkInitialWinOrBust() {
        int points = getPlayerPoints(state.getPlayer());
        if (points == 21 || points > 21) {
            state.setGameEnded(true);
        }
    }

    private void checkIfBusted() {
        int points = getPlayerPoints(state.getPlayer());
        if (points >= 22 || points == 21) {
            state.setGameEnded(true);
        }
    }

    private void drawDealer() {
        while (!isParticipantBusted(state.getDealer()) &&
                getPlayerPoints(state.getDealer()) < getPlayerPoints(state.getPlayer()) && !state.getDeck().isDeckEmpty()) {
            drawCard(state.getDealer());
            ui.showHand("Dealer", state.getDealer().getHand(), getPlayerPoints(state.getDealer()));
        }
        state.setGameEnded(true);
    }

    public boolean isGameEnded() {
        return state.isGameEnded();
    }

    private void drawCard(Participant participant) {
        if (state.getDeck().isDeckEmpty()) {
            System.out.println("no more cards in the deck! Game ends");
            state.setGameEnded(true);
            return;
        }
        Card card = state.getDeck().removeCard();
        participant.getHand().cards().add(card);
    }

    private boolean isParticipantBusted(Participant p) {
        return getPlayerPoints(p) >= 22;
    }

    public void endGame() {
        int playerPoints = getPlayerPoints(state.getPlayer());
        int dealerPoints = getPlayerPoints(state.getDealer());
        ui.showGameEnd(playerPoints, dealerPoints);
    }
}

package org.blackjack.models.Nominations;

public enum PlayerActions {

    DRAW(0),
    STAND(1);

    private final int acceptedAction;

    PlayerActions(int acceptedAction) {
        this.acceptedAction = acceptedAction;
    }

    public int getAction() {
        return acceptedAction;
    }

    public static PlayerActions fromInt(int intValue) {
        for (PlayerActions action : PlayerActions.values()) {
            if (action.getAction() == intValue) {
                return action;
            }
        }
        throw new IllegalArgumentException("The inserted value was not recognized");
    }
}

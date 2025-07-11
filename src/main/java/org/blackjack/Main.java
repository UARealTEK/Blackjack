package org.blackjack;

import org.blackjack.services.GameLoop;

public class Main {
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.gameLoop();
    }
}
package org.blackjack.services;

import org.blackjack.models.Nominations.PlayerActions;
import org.blackjack.models.objects.Deck;
import org.blackjack.models.objects.Hand;
import org.blackjack.models.participants.Dealer;
import org.blackjack.models.participants.Player;

import java.util.ArrayList;
import java.util.Scanner;

import static org.blackjack.utils.PointsCounter.getPlayerPoints;

public class GameLoop {

    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);

        Deck deck = new Deck();
        Player player = new Player(new Hand(new ArrayList<>()));
        Dealer dealer = new Dealer(new Hand(new ArrayList<>()));
        GameState state = new GameState(player, dealer, deck);

        GameEngine engine = new GameEngine(state, ui);

        engine.startGame();

        while (!engine.isGameEnded()) {
            int playerPoints = getPlayerPoints(state.getPlayer());

            if (playerPoints == 21) {
                System.out.println("You hit 21!");
                engine.endGame();
                break;
            }

            if (playerPoints >= 22) {
                System.out.println("You busted!");
                engine.endGame();
                break;
            }

            PlayerActions action = ui.askUserAction();
            engine.performUserAction(action);
        }

        engine.endGame();
    }
}

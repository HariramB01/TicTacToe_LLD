package helper;

import controller.TicTacToeGame;
import strategy.PlayerStrategy;
import handler.WonState;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGameHelper {

    private final List<TicTacToeGame> ticTacToeGames = new ArrayList<>();

    public TicTacToeGameHelper() {
    }

    public void startNewGame(List<PlayerStrategy> players, int boardSize) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialize(players, boardSize, boardSize);
        game.play();
        ticTacToeGames.add(game);
    }

    public void printAllGames() {

        if (ticTacToeGames.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }

        System.out.println("\n========= GAME HISTORY =========");

        int gameNumber = 1;
        for (TicTacToeGame game : ticTacToeGames) {

            System.out.println("\nGame #" + gameNumber++);

            game.getBoard().printBoard();

            if (game.getGameContext().getCurrentGameState() instanceof WonState wonState) {
                System.out.println(
                        "Winner: " +
                                wonState.getWinner().getPlayerStrategy().getPlayerName() +
                                " [" + wonState.getWinner().getSymbol() + "]"
                );
            } else {
                System.out.println("Result: Draw");
            }
        }

        System.out.println("================================\n");
    }
}

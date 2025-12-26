package handler;

import utility.Player;
import utility.GameResult;

public class WonState implements GameState {

    private final Player winner;

    public WonState(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    @Override
    public void nextMove(GameContext context, Player player, GameResult result) {
        // No-op (game already finished)
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}

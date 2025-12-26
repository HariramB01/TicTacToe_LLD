package handler;

import utility.Player;
import utility.GameResult;

public class DrawState implements GameState {

    @Override
    public void nextMove(GameContext context, Player player, GameResult result) {
        // No-op
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}

package handler;

import utility.GameResult;
import utility.Player;

public interface GameState {
    void nextMove(GameContext context, Player player, GameResult result);
    boolean isGameOver();
}

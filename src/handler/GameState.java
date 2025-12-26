package handler;

import utility.Player;

public interface GameState {
    void nextMove(GameContext context, Player player, boolean hasWon);
    boolean isGameOver();
    void printState();
}

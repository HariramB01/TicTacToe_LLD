package handler;

import utility.Player;

public class XWonState implements GameState{
    @Override
    public void nextMove(GameContext context, Player player, boolean hasWon) {
    }

    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public void printState() {
        System.out.println("X Won");
    }
}

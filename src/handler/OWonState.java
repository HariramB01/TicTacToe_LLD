package handler;

import utility.Player;

public class OWonState implements GameState{
    @Override
    public void nextMove(GameContext context, Player player, boolean hasWon) {
    }

    @Override
    public void printState() {
        System.out.println("O Won");
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}

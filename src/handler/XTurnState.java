package handler;

import utility.Player;
import utility.Symbol;

public class XTurnState implements GameState {

    @Override
    public void nextMove(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setCurrentGameState(player.getSymbol() == Symbol.O ? new OWonState() : new XWonState());
        } else {
            System.out.println("next O Turn");
            context.setCurrentGameState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void printState() {
        System.out.println("X Turn");
    }

}

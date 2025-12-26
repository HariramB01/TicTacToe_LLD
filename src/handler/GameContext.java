package handler;

import utility.Player;

public class GameContext {

    private GameState currentGameState;

    public GameContext(){
        this.currentGameState = new XTurnState();
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public boolean isGameOver() {
        return currentGameState.isGameOver();
    }

    public void nextState(Player player, boolean hasWon){
        currentGameState.nextMove(this, player, hasWon);
    }

}

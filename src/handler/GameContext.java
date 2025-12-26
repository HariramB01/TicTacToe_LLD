package handler;

import utility.Player;

import java.util.List;

public class GameContext {

    private GameState currentGameState;
    private List<Player> players;
    private int currentPlayerIndex;

    public GameContext(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.currentGameState = new BoardInProgressState();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void moveToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
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

    public void nextState(Player player, utility.GameResult result) {
        currentGameState.nextMove(this, player, result);
    }
}

package utility;

import strategy.PlayerStrategy;

public class Player {
    private int playerOrder;
    private Symbol symbol;
    private PlayerStrategy playerStrategy;

    public Player(int playerOrder, Symbol symbol, PlayerStrategy playerStrategy) {
        this.playerOrder = playerOrder;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerOrder=" + playerOrder +
                ", symbol=" + symbol +
                ", playerStrategy=" + playerStrategy +
                '}';
    }
}

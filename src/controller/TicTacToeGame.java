package controller;

import handler.GameContext;
import handler.GameState;
import handler.WonState;
import strategy.PlayerStrategy;
import utility.Board;
import utility.Player;
import utility.Position;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameContext gameContext;
    private Player winner;


    public void initialize(List<PlayerStrategy> playerStrategies,
                           int rows, int cols) {
        board = new Board(rows, cols);
        players = new ArrayList<>();
        createPlayers(playerStrategies);
        currentPlayer = players.get(0);
        gameContext = new GameContext(players);
    }

    private void createPlayers(List<PlayerStrategy> playerStrategies) {
        int count = 1;
        for (PlayerStrategy playerStrategy : playerStrategies) {
            players.add(new Player(count++, playerStrategy.getSymbol(), playerStrategy));
        }
    }

    public void play() {
        board.printBoard();
        do {
            Player currentPlayer = gameContext.getCurrentPlayer();
            // validate the move based on the player strategy
            Position makeMove = currentPlayer.getPlayerStrategy().makeMove(board);
            // after validation
            // update the move in the board
            board.makeMove(makeMove, currentPlayer);
            // after every move
            // check the game state
            board.printBoard();
            board.checkGameState(gameContext, currentPlayer);
            if (!gameContext.isGameOver()) {
                switchPlayer();
            }

        } while (!gameContext.isGameOver());
        {
            announceResult();
        }
    }

    private void switchPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.size();
        currentPlayer = players.get(nextIndex);
        System.out.println(
                "Next Turn: " + currentPlayer.getPlayerStrategy().getPlayerName()
        );
    }

    private void announceResult() {
        GameState state = gameContext.getCurrentGameState();

        if (state instanceof WonState) {
            winner = ((WonState) state).getWinner();
            System.out.println(
                    "Player " + winner.getPlayerStrategy().getPlayerName() +
                            " with symbol '" + winner.getSymbol() + "' wins!"
            );
        } else {
            System.out.println("It's a draw!");
        }
    }

    public Board getBoard() {
        return board;
    }

    public GameContext getGameContext() {
        return gameContext;
    }

    @Override
    public String toString() {
        return "TicTacToeGame{" +
                "board=" + board +
                ", players=" + players +
                ", currentPlayer=" + currentPlayer +
                ", gameContext=" + gameContext +
                ", winner=" + winner +
                '}';
    }
}

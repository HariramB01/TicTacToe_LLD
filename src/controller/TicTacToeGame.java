package controller;

import handler.GameContext;
import handler.GameState;
import handler.OWonState;
import handler.XWonState;
import strategy.PlayerStrategy;
import utility.Board;
import utility.Player;
import utility.Position;
import utility.Symbol;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;


    public TicTacToeGame(PlayerStrategy playerStrategyX, PlayerStrategy playerStrategyO,
                         int rows, int cols) {
        board = new Board(rows, cols);
        playerX = new Player(Symbol.X, playerStrategyX);
        playerO = new Player(Symbol.O, playerStrategyO);
        currentPlayer = playerX;
        gameContext = new GameContext();
    }

    public void play() {
        do{
            board.printBoard();
//            gameContext.getCurrentGameState().printState();
            // validate the move based on the player strategy
            Position makeMove = currentPlayer.getPlayerStrategy().makeMove(board);
            // after validation
            // update the move in the board
            board.makeMove(makeMove, currentPlayer);
            // after every move
            // check the game state
            board.checkGameState(gameContext, currentPlayer);
            if(!gameContext.isGameOver())
                switchPlayer();
        } while(!gameContext.isGameOver());{
            announceResult(currentPlayer);
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        System.out.println("switch player: "+ currentPlayer.getPlayerStrategy().getPlayerName());
    }

    private void announceResult(Player currentPlayer) {
        GameState state = gameContext.getCurrentGameState();
        board.printBoard();
        if(state instanceof XWonState){
            System.out.println("Player "+ currentPlayer.getPlayerStrategy().getPlayerName()+" X Wins");
        } else if (state instanceof OWonState) {
            System.out.println("Player "+ currentPlayer.getPlayerStrategy().getPlayerName()+" O Wins");
        } else {
            System.out.println("It's a draw!");
        }
    }

}

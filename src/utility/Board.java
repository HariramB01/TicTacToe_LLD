package utility;

import handler.GameContext;
import helper.BoardHelper;

public class Board {

    private int rows;
    private int cols;
    private Symbol[][] grid;
    private BoardHelper boardHelper;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Symbol[rows][cols];
        boardHelper = BoardHelper.getBoardHelperInstance();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position move) {
        return boardHelper.isValidMove(move,this);
    }

    public void makeMove(Position move, Player currentPlayer) {
        boardHelper.makeMove(move, currentPlayer, this);
    }

    public void checkGameState(GameContext gameContext, Player currentPlayer) {
        boardHelper.checkGameState(gameContext, currentPlayer, this);
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }

                if (j < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Symbol[][] getGrid() {
        return grid;
    }

}

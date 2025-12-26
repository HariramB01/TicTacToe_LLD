package utility;

import handler.GameContext;
import helper.BoardHelper;

import java.util.Arrays;

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

                if (symbol == Symbol.EMPTY) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + symbol + " ");
                }

                if (j < cols - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            // print dynamic row separator
            if (i < rows - 1) {
                for (int k = 0; k < cols; k++) {
                    System.out.print("---");
                    if (k < cols - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
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

    @Override
    public String toString() {
        return "Board{" +
                "rows=" + rows +
                ", cols=" + cols +
                ", grid=" + Arrays.toString(grid) +
                ", boardHelper=" + boardHelper +
                '}';
    }
}

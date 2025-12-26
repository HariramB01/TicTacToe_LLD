package helper;

import handler.GameContext;
import utility.Board;
import utility.Player;
import utility.Position;
import utility.Symbol;

public class BoardHelper {

    private static volatile BoardHelper boardHelperInstance;

    private BoardHelper() {
    }

    public static BoardHelper getBoardHelperInstance() {
        if (boardHelperInstance == null) {
            synchronized (BoardHelper.class) {
                if (boardHelperInstance == null) {
                    boardHelperInstance = new BoardHelper();
                }
            }
        }
        return boardHelperInstance;
    }

    public boolean isValidMove(Position move, Board board) {
        return move.getCol() >= 0 && move.getCol() < board.getCols() &&
                move.getRow() >= 0 && move.getRow() < board.getRows()
                && board.getGrid()[move.getRow()][move.getCol()] == Symbol.EMPTY;
    }

    public void makeMove(Position move, Player currentPlayer, Board board) {
        board.getGrid()[move.getRow()][move.getCol()] = currentPlayer.getSymbol();
    }

    public void checkGameState(GameContext gameContext, Player currentPlayer, Board board) {
        for (int i = 0; i < board.getRows(); i++) {
            if (board.getGrid()[i][0] != Symbol.EMPTY && isWinningLine(board.getGrid()[i])) {
                gameContext.nextState(currentPlayer, true);
                return;
            }
        }
        for (int i = 0; i < board.getCols(); i++) {
            Symbol[] column = new Symbol[board.getRows()];
            for (int j = 0; j < board.getRows(); j++) {
                column[j] = board.getGrid()[j][i];
            }
            if (column[0] != Symbol.EMPTY && isWinningLine(column)) {
                gameContext.nextState(currentPlayer, true);
                return;
            }
        }
        Symbol[] diagonal1 = new Symbol[Math.min(board.getRows(), board.getCols())];
        Symbol[] diagonal2 = new Symbol[Math.min(board.getRows(), board.getCols())];
        for (int i = 0; i < Math.min(board.getRows(), board.getCols()); i++) {
            diagonal1[i] = board.getGrid()[i][i];
            diagonal2[i] = board.getGrid()[i][board.getCols() - 1 - i];
        }
        if (diagonal1[0] != Symbol.EMPTY && isWinningLine(diagonal1)) {
            gameContext.nextState(currentPlayer, true);
            return;
        }
        if (diagonal2[0] != Symbol.EMPTY && isWinningLine(diagonal2)) {
            gameContext.nextState(currentPlayer, true);
            return;
        }
        gameContext.nextState(currentPlayer, false);
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }
}

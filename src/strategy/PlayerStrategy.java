package strategy;

import utility.Board;
import utility.Position;
import utility.Symbol;

public interface PlayerStrategy {
    Position makeMove(Board board);

    String getPlayerName();

    Symbol getSymbol();
}

package strategy;

import utility.Board;
import utility.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);

    String getPlayerName();
}

package handler;

import utility.GameResult;
import utility.Player;

public class NextTurnState extends InProgressState {

    @Override
    public void nextMove(GameContext context, Player player, GameResult result) {

        // move to next player in circular order
        context.moveToNextPlayer();

        Player nextPlayer = context.getCurrentPlayer();

        System.out.println(
                "Next Turn: " +
                        nextPlayer.getPlayerStrategy().getPlayerName() +
                        " [" + nextPlayer.getSymbol() + "]"
        );

        context.setCurrentGameState(new BoardInProgressState());
    }
}

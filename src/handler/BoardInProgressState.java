package handler;

import utility.GameResult;
import utility.Player;

public class BoardInProgressState extends InProgressState {

    @Override
    public void nextMove(GameContext context, Player player, GameResult result) {

        switch (result) {

            case WIN:
                context.setCurrentGameState(new WonState(player));
                return;

            case DRAW:
                context.setCurrentGameState(new DrawState());
                return;

            case IN_PROGRESS:
                // move to next player ONCE
                context.moveToNextPlayer();

                Player nextPlayer = context.getCurrentPlayer();
                System.out.println(
                        "Next Turn: " +
                                nextPlayer.getPlayerStrategy().getPlayerName() +
                                " [" + nextPlayer.getSymbol() + "]"
                );

                // remain in same state
                context.setCurrentGameState(this);
                return;
        }
    }
}

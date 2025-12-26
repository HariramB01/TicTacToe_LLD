//package handler;
//
//import utility.Player;
//import utility.Symbol;
//
//public class OTurnState extends InProgressState {
//
//    @Override
//    public void nextMove(GameContext context, Player player, boolean hasWon) {
//        if (hasWon) {
//            context.setCurrentGameState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
//        } else {
//            System.out.println("next X Turn");
//            context.setCurrentGameState(new XTurnState());
//        }
//    }
//
//}

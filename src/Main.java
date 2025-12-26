import controller.TicTacToeGame;
import strategy.HumanPlayerStrategy;
import strategy.PlayerStrategy;

public class Main {
    public static void main(String[] args) {
        PlayerStrategy playerStrategyX = new HumanPlayerStrategy("Hariram");
        PlayerStrategy playerStrategyO = new HumanPlayerStrategy("Harish");
        TicTacToeGame game = new TicTacToeGame(playerStrategyX, playerStrategyO, 3, 3);
        game.play();
    }
}
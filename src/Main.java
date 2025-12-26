import helper.TicTacToeGameHelper;
import strategy.AIPlayerStrategy;
import strategy.DynamicPlayerStrategy;
import strategy.PlayerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to TicTacToe Game");

        Scanner sc = new Scanner(System.in);

        TicTacToeGameHelper gameHelper = new TicTacToeGameHelper();

        boolean playing = true;
        while (playing) {

            System.out.print("Enter total number of players (2–5): ");
            int totalPlayers = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter number of human players (1–" + totalPlayers + "): ");
            int humanPlayers = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter number of board size: ");
            int boardSize = sc.nextInt();
            sc.nextLine();

            char[] symbols = {'X', 'O', 'A', 'B', 'C', 'D', 'E'};
            List<PlayerStrategy> players = new ArrayList<>();
            int symbolIndex = 0;

            // Human players
            for (int i = 0; i < humanPlayers; i++) {
                System.out.print("Enter name for Human Player " + (i + 1) + ": ");
                String name = sc.nextLine();
                players.add(new DynamicPlayerStrategy(name, symbols[symbolIndex++]));
            }

            // AI players
            for (int i = humanPlayers; i < totalPlayers; i++) {
                String aiName = "AI_Player_" + (i - humanPlayers + 1);
                players.add(new AIPlayerStrategy(aiName, symbols[symbolIndex++]));
            }

            gameHelper.startNewGame(players, boardSize);
            gameHelper.printAllGames();

            System.out.println("still want to continue playing??? y or n");
            String continuePlaying = sc.nextLine();
            if (continuePlaying.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
    }
}

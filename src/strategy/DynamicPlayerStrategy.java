package strategy;

import utility.Board;
import utility.Position;
import utility.Symbol;

import java.util.Scanner;

public class DynamicPlayerStrategy implements PlayerStrategy{

    private String playerName;
    private Symbol symbol;
    private Scanner scanner;

    public DynamicPlayerStrategy(String playerName, char symbol){
        this.playerName = playerName;
        this.symbol = Symbol.fromChar(symbol);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        while(true){
            System.out.printf("%s, enter your move (row[0-%d] and col[0-%d): ", playerName, rows, cols);
            try{
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);
                // move validation
                if(board.isValidMove(move)){
                    return move;
                }
                System.out.println("Invalid move. Try again");
            } catch (Exception e){
                System.out.println("Invalid input. Please enter row and column as numbers.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

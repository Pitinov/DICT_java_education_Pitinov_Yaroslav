package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        if (!isValidInput(input)) {
            System.out.println("Invalid input. Please enter a string of 9 characters containing only X, O, and _.");
            return;
        }

        displayGameBoard(input);
        analyzeGameState(input);
    }

    private static boolean isValidInput(String input) {
        return input.matches("[XO_]{9}");
    }

    private static void displayGameBoard(String cells) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char symbol = cells.charAt(i * 3 + j);
                System.out.print(symbol + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void analyzeGameState(String cells) {
        boolean xWins = checkWin(cells, 'X');
        boolean oWins = checkWin(cells, 'O');
        boolean hasEmptyCells = cells.contains("_");

        if (Math.abs(countSymbol(cells, 'X') - countSymbol(cells, 'O')) >= 2) {
            System.out.println("Impossible");
        } else if (xWins && oWins || xWins && countSymbol(cells, 'X') > countSymbol(cells, 'O')) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (hasEmptyCells) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    private static boolean checkWin(String cells, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (cells.charAt(i * 3) == symbol && cells.charAt(i * 3 + 1) == symbol && cells.charAt(i * 3 + 2) == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cells.charAt(i) == symbol && cells.charAt(i + 3) == symbol && cells.charAt(i + 6) == symbol) {
                return true;
            }
        }

        return cells.charAt(0) == symbol && cells.charAt(4) == symbol && cells.charAt(8) == symbol ||
                cells.charAt(2) == symbol && cells.charAt(4) == symbol && cells.charAt(6) == symbol;
    }

    private static int countSymbol(String cells, char symbol) {
        return (int) cells.chars().filter(c -> c == symbol).count();
    }
}


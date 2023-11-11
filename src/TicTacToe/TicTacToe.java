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
}


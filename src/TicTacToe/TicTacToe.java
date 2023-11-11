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

        char[][] gameBoard = initializeGameBoard(input);

        displayGameBoard(gameBoard);

        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(gameBoard, row, col)) {
                    makeMove(gameBoard, row, col, 'X');
                    displayGameBoard(gameBoard);

                    if (checkGameResult(gameBoard, 'X')) {
                        System.out.println("X wins");
                        break;
                    }

                    if (isBoardFull(gameBoard)) {
                        System.out.println("Draw");
                        break;
                    }

                    // Opponent's move (for simplicity, always 'O')
                    makeOpponentMove(gameBoard);
                    displayGameBoard(gameBoard);

                    if (checkGameResult(gameBoard, 'O')) {
                        System.out.println("O wins");
                        break;
                    }

                    if (isBoardFull(gameBoard)) {
                        System.out.println("Draw");
                        break;
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    private static boolean isValidInput(String input) {
        return input.matches("[XO_]{9}");
    }

    private static char[][] initializeGameBoard(String input) {
        char[][] gameBoard = new char[3][3];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = input.charAt(index++);
            }
        }

        return gameBoard;
    }

    private static void displayGameBoard(char[][] gameBoard) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean isValidMove(char[][] gameBoard, int row, int col) {
        return row >= 1 && row <= 3 && col >= 1 && col <= 3 && gameBoard[3 - col][row - 1] == '_';
    }

    private static void makeMove(char[][] gameBoard, int row, int col, char symbol) {
        gameBoard[3 - col][row - 1] = symbol;
    }

    private static void makeOpponentMove(char[][] gameBoard) {
        // For simplicity, opponent always places 'O' in the first available empty cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == '_') {
                    gameBoard[i][j] = 'O';
                    return;
                }
            }
        }
    }

    private static boolean checkGameResult(char[][] gameBoard, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol ||
                    gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol) {
                return true;
            }
        }

        return gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol ||
                gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol;
    }

    private static boolean isBoardFull(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
}



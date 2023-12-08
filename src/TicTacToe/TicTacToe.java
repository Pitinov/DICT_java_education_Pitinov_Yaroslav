package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] gameBoard = createEmptyGameBoard();

        displayGameBoard(gameBoard);

        char currentPlayer = 'X';

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(gameBoard, row, col)) {
                    makeMove(gameBoard, row, col, currentPlayer);
                    displayGameBoard(gameBoard);

                    if (checkGameResult(gameBoard, currentPlayer)) {
                        System.out.println(currentPlayer + " wins");
                        break;
                    }

                    if (isBoardFull(gameBoard)) {
                        System.out.println("Draw");
                        break;
                    }

                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    private static char[][] createEmptyGameBoard() {
        char[][] gameBoard = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = ' ';
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
        return row >= 1 && row <= 3 && col >= 1 && col <= 3 && gameBoard[row - 1][col - 1] == ' ';
    }

    private static void makeMove(char[][] gameBoard, int row, int col, char symbol) {
        gameBoard[row - 1][col - 1] = symbol;
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
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}



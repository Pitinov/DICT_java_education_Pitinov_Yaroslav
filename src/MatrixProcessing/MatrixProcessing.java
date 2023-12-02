package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nA = scanner.nextInt();
        int mA = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, nA, mA);

        int nB = scanner.nextInt();
        int mB = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, nB, mB);

        if (nA == nB && mA == mB) {
            int[][] sumMatrix = addMatrices(matrixA, matrixB);
            printMatrix(sumMatrix);
        } else {
            System.out.println("ERROR");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sumMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

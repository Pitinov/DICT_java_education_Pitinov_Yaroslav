import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");

            System.out.print("Your choice: > ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 4:
                    transposeMatrix(scanner);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void transposeMatrix(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.print("Your choice: > ");
        int transposeOption = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter matrix size: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = readMatrix(scanner, n, m);

        int[][] transposedMatrix = transpose(matrix, transposeOption);
        printMatrix(transposedMatrix);
    }

    private static int[][] transpose(int[][] matrix, int option) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[rows][cols];

        switch (option) {
            case 1:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        transposedMatrix[i][j] = matrix[j][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        transposedMatrix[i][j] = matrix[cols - 1 - j][rows - 1 - i];
                    }
                }
                break;
            case 3:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        transposedMatrix[i][j] = matrix[i][cols - 1 - j];
                    }
                }
                break;
            case 4:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        transposedMatrix[i][j] = matrix[rows - 1 - i][j];
                    }
                }
                break;
        }

        return transposedMatrix;
    }

    private static void addMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int nA = scanner.nextInt();
        int mA = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixA = readMatrix(scanner, nA, mA);

        System.out.print("Enter size of second matrix: > ");
        int nB = scanner.nextInt();
        int mB = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixB = readMatrix(scanner, nB, mB);

        if (nA == nB && mA == mB) {
            int[][] sumMatrix = addMatrices(matrixA, matrixB);
            printMatrix(sumMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.print("Enter size of matrix: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = readMatrix(scanner, n, m);

        System.out.print("Enter constant: > ");
        int constant = scanner.nextInt();
        scanner.nextLine();

        multiplyMatrixByConstant(matrix, constant);
        printMatrix(matrix);
    }

    private static void multiplyMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int nA = scanner.nextInt();
        int mA = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixA = readMatrix(scanner, nA, mA);

        System.out.print("Enter size of second matrix: > ");
        int nB = scanner.nextInt();
        int mB = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixB = readMatrix(scanner, nB, mB);

        if (mA == nB) {
            int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
            printMatrix(productMatrix);
        } else {
            System.out.println("The operation cannot be performed.");
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

    private static void multiplyMatrixByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] *= constant;
            }
        }
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

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] productMatrix = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return productMatrix;
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

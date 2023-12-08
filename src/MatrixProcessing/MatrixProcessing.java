import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
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
                case 5:
                    calculateDeterminant(scanner);
                    break;
                case 6:
                    inverseMatrix(scanner);
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

    private static void transposeMatrix(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.print("Your choice: > ");
        int transposeType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter matrix size: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = readMatrix(scanner, n, m);

        int[][] transposedMatrix = transposeMatrix(matrix, transposeType);
        printMatrix(transposedMatrix);
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = readMatrix(scanner, n, m);

        if (n == m) {
            int determinant = calculateDeterminant(matrix);
            System.out.println("The result is: " + determinant);
        } else {
            System.out.println("The matrix is not square. Determinant cannot be calculated.");
        }
    }

    private static void inverseMatrix(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = readMatrix(scanner, n, m);

        if (n == m) {
            double determinant = calculateDeterminant(matrix);

            if (determinant != 0) {
                double[][] inverseMatrix = calculateInverseMatrix(matrix, determinant);
                printMatrix(inverseMatrix);
            } else {
                System.out.println("This matrix doesn't have an inverse.");
            }
        } else {
            System.out.println("The matrix is not square. Inverse matrix cannot be calculated.");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int n, int m) {
        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine(); // consume the newline character
        return matrix;
    }

    private static void multiplyMatrixByConstant(int[][] matrix, int constant) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= constant;
            }
        }
    }

    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int n = matrixA.length;
        int m = matrixA[0].length;
        int[][] sumMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sumMatrix;
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int nA = matrixA.length;
        int mA = matrixA[0].length;
        int nB = matrixB.length;
        int mB = matrixB[0].length;

        int[][] productMatrix = new int[nA][mB];
        for (int i = 0; i < nA; i++) {
            for (int j = 0; j < mB; j++) {
                for (int k = 0; k < mA; k++) {
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return productMatrix;
    }

    private static int[][] transposeMatrix(int[][] matrix, int transposeType) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] transposedMatrix = new int[m][n];

        switch (transposeType) {
            case 1: // Main diagonal
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        transposedMatrix[j][i] = matrix[i][j];
                    }
                }
                break;
            case 2: // Side diagonal
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        transposedMatrix[m - 1 - j][n - 1 - i] = matrix[i][j];
                    }
                }
                break;
            case 3: // Vertical line
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        transposedMatrix[i][m - 1 - j] = matrix[i][j];
                    }
                }
                break;
            case 4: // Horizontal line
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        transposedMatrix[n - 1 - i][j] = matrix[i][j];
                    }
                }
                break;
        }

        return transposedMatrix;
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (n != m) {
            throw new IllegalArgumentException("Matrix is not square");
        }

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int j = 0; j < m; j++) {
            determinant += matrix[0][j] * cofactor(matrix, 0, j);
        }

        return determinant;
    }

    private static int cofactor(int[][] matrix, int row, int col) {
        return (int) Math.pow(-1, row + col) * calculateDeterminant(minor(matrix, row, col));
    }

    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int[][] minorMatrix = new int[n][m];

        for (int i = 0, newRow = 0; i < matrix.length; i++) {
            if (i != row) {
                for (int j = 0, newCol = 0; j < matrix[0].length; j++) {
                    if (j != col) {
                        minorMatrix[newRow][newCol] = matrix[i][j];
                        newCol++;
                    }
                }
                newRow++;
            }
        }

        return minorMatrix;
    }

    private static double[][] calculateInverseMatrix(int[][] matrix, double determinant) {
        int n = matrix.length;
        int m = matrix[0].length;

        double[][] inverseMatrix = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                double cofactorValue = cofactor(matrix, i, j);
                inverseMatrix[i][j] = cofactorValue / determinant;
            }
        }

        return inverseMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

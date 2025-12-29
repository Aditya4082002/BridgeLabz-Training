import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {

        int rows = 2;
        int columns = 2;

        // Create two random matrices
        int[][] matrixA = createRandomMatrix(rows, columns);
        int[][] matrixB = createRandomMatrix(rows, columns);

        System.out.println("Matrix A:");
        displayMatrix(matrixA);

        System.out.println("\nMatrix B:");
        displayMatrix(matrixB);

        // Matrix Addition
        System.out.println("\nMatrix Addition (A + B):");
        displayMatrix(addMatrices(matrixA, matrixB));

        // Matrix Subtraction
        System.out.println("\nMatrix Subtraction (A - B):");
        displayMatrix(subtractMatrices(matrixA, matrixB));

        // Matrix Multiplication
        System.out.println("\nMatrix Multiplication (A × B):");
        displayMatrix(multiplyMatrices(matrixA, matrixB));
    }

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int columns) {

        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(10); // values 0–9
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {

        int[][] result = new int[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB) {

        int[][] result = new int[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {

        int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    // Method to display matrix
    public static void displayMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

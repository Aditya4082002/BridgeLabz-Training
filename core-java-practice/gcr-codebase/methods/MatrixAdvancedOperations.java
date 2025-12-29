import java.util.Random;

public class MatrixAdvancedOperations {

    public static void main(String[] args) {

        // ----- 2x2 Matrix Operations -----
        int[][] matrix2x2 = createRandomMatrix(2, 2);

        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);

        System.out.println("\nTranspose of 2x2 Matrix:");
        displayMatrix(findTranspose(matrix2x2));

        int det2 = findDeterminant2x2(matrix2x2);
        System.out.println("\nDeterminant of 2x2 Matrix: " + det2);

        System.out.println("\nInverse of 2x2 Matrix:");
        findInverse2x2(matrix2x2);

        // ----- 3x3 Matrix Operations -----
        int[][] matrix3x3 = createRandomMatrix(3, 3);

        System.out.println("\n\n3x3 Matrix:");
        displayMatrix(matrix3x3);

        System.out.println("\nTranspose of 3x3 Matrix:");
        displayMatrix(findTranspose(matrix3x3));

        int det3 = findDeterminant3x3(matrix3x3);
        System.out.println("\nDeterminant of 3x3 Matrix: " + det3);

        System.out.println("\nInverse of 3x3 Matrix:");
        findInverse3x3(matrix3x3);
    }

    // Method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int columns) {

        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(9) + 1; // values 1–9
            }
        }
        return matrix;
    }

    // Method to find transpose of a matrix
    public static int[][] findTranspose(int[][] matrix) {

        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // Method to find determinant of 2x2 matrix
    public static int findDeterminant2x2(int[][] matrix) {

        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    // Method to find determinant of 3x3 matrix
    public static int findDeterminant3x3(int[][] m) {

        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Method to find inverse of 2x2 matrix
    public static void findInverse2x2(int[][] matrix) {

        int determinant = findDeterminant2x2(matrix);

        if (determinant == 0) {
            System.out.println("Inverse not possible (Determinant = 0)");
            return;
        }

        double[][] inverse = new double[2][2];

        inverse[0][0] = matrix[1][1] / (double) determinant;
        inverse[0][1] = -matrix[0][1] / (double) determinant;
        inverse[1][0] = -matrix[1][0] / (double) determinant;
        inverse[1][1] = matrix[0][0] / (double) determinant;

        for (double[] row : inverse) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    // Method to find inverse of 3x3 matrix
    public static void findInverse3x3(int[][] m) {

        int determinant = findDeterminant3x3(m);

        if (determinant == 0) {
            System.out.println("Inverse not possible (Determinant = 0)");
            return;
        }

        double[][] inverse = new double[3][3];

        inverse[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / (double) determinant;
        inverse[0][1] = (m[0][2]*m[2][1] - m[0][1]*m[2][2]) / (double) determinant;
        inverse[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / (double) determinant;

        inverse[1][0] = (m[1][2]*m[2][0] - m[1][0]*m[2][2]) / (double) determinant;
        inverse[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / (double) determinant;
        inverse[1][2] = (m[0][2]*m[1][0] - m[0][0]*m[1][2]) / (double) determinant;

        inverse[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / (double) determinant;
        inverse[2][1] = (m[0][1]*m[2][0] - m[0][0]*m[2][1]) / (double) determinant;
        inverse[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / (double) determinant;

        for (double[] row : inverse) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

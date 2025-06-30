public class MatrixMultiplication {

    // Function to multiply two matrices
    static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;                        // Number of rows in A
        int colsA = A[0].length;                     // Number of columns in A
        int colsB = B[0].length;                     // Number of columns in B

        int[][] result = new int[rowsA][colsB];      // Result matrix of size rowsA x colsB

        for (int i = 0; i < rowsA; i++) {            // Loop through rows of A
            for (int j = 0; j < colsB; j++) {        // Loop through columns of B
                for (int k = 0; k < colsA; k++) {    // Loop through columns of A / rows of B
                    result[i][j] += A[i][k] * B[k][j]; // Multiply and accumulate
                }
            }
        }

        return result;                               // Return the resulting matrix
    }

    // Function to print a matrix
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {            // Loop through rows
            for (int j = 0; j < matrix[0].length; j++) {     // Loop through columns
                System.out.print(matrix[i][j] + " ");        // Print each element
            }
            System.out.println();                            // New line after each row
        }
    }

    public static void main(String[] args) {
        int[][] A = { {1, 2, 3}, {4, 5, 6} };        // 2x3 matrix A
        int[][] B = { {7, 8}, {9, 10}, {11, 12} };   // 3x2 matrix B

        // Check if multiplication is possible
        if (A[0].length != B.length) {
            System.out.println("Matrix multiplication not possible."); // Validate dimensions
            return;
        }

        int[][] product = multiplyMatrices(A, B);   // Call the multiply function

        System.out.println("Product of matrices A and B:");
        printMatrix(product);                      // Print the result matrix
    }
}

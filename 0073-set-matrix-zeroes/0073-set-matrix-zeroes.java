class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        boolean firstRow = false;
        boolean firstColumn = false;

        // Corrected check for first column
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }

        // Corrected check for first row
        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        // Mark zeros
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Apply markers
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row if needed
        if (firstRow) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }

        // Zero first column if needed
        if (firstColumn) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        //https://www.youtube.com/watch?v=A0_hEzQFP9U
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        temp[i][k] = 0; // zero out the entire row
                    }
                    for (int k = 0; k < m; k++) {
                        temp[k][j] = 0; // zero out the entire column
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        t[i][j] = 1;
                    } else {
                        t[i][j] = 1 + Math.min(Math.min(t[i - 1][j], t[i - 1][j - 1]), t[i][j - 1]);

                    }
                }
                result = Math.max(t[i][j], result);
            }

        }
        return result * result;
    }
}
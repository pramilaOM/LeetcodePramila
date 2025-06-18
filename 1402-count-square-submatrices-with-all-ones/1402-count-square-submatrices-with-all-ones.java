class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        t[i][j] = 1 + Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]);
                    }
                }

                result += t[i][j];
            }
        }

        return result;
    }
}
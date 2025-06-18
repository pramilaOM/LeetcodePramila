class Solution {
    int m, n;

    int solve(int i, int j, int[][] matrix, int[][] t) {

    if(i >= matrix.length|| j>= matrix[0].length) return 0;

    if(matrix[i][j] == 0) return 0;

    if(t[i][j] != -1) return t[i][j];

    int right = solve(i, j+1, matrix, t);
    int diagonal=solve(i+1, j+1, matrix, t);
    int below = solve(i+1, j, matrix, t);

    return t[i][j] = 1+ Math.min(Math.min(right,diagonal),below);

    }

    public int countSquares(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int result = 0;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = -1;

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += solve(i, j, matrix, t);

            }
        }
        return result;
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        //bottom up
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid, m, n);
    }

    public int solve(int[][] grid, int m, int n) {
        int[][] t = new int[m][n];
        t[0][0] = grid[0][0];

        //first row
        for (int i = 1; i < n; i++) {
            t[0][i] = grid[0][i] + t[0][i - 1];
        }
        //first column
        for (int i = 1; i < m; i++) {
            t[i][0] = grid[i][0] + t[i - 1][0];
        }
        //remaining

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = grid[i][j] + Math.min(t[i][j - 1], t[i - 1][j]);
            }
        }
        return t[m - 1][n - 1];
    }
}
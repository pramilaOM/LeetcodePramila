class Solution {

    int DFS(int[][] grid, int m, int n) {
        int[][] t = new int[m][n];
        t[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            t[i][0] = t[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            t[0][j] = t[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                t[i][j] = grid[i][j] + Math.min(t[i - 1][j], t[i][j - 1]);
            }
        }

        return t[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return DFS(grid, m, n);
    }
}
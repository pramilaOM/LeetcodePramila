class Solution {

    int solve(int[][] grid, int i, int j, int m, int n, int[][] t) {
        if (i == m - 1 && j == n - 1)
            return t[i][j] = grid[i][j];

        if (t[i][j] != -1)
            return t[i][j];

        if (i == m - 1) {
            return t[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n, t);
        } else if (j == n - 1) {
            return t[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n, t);
        } else {
            return t[i][j] = grid[i][j] + Math.min(solve(grid, i, j + 1, m, n, t), solve(grid, i + 1, j, m, n, t));
        }
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(grid, 0, 0, m, n, t);

    }
}
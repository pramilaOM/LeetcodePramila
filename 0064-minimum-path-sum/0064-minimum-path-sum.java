class Solution {
    //memo
    int[][] t;

    public int solve(int[][] grid, int i, int j, int row, int column) {
        if (i == row - 1 && j == column - 1) {
            return grid[i][j];
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        if (i == row - 1) {
            return t[i][j] = grid[i][j] + solve(grid, i, j + 1, row, column);
        } else if (j == column - 1) {
            return t[i][j] = grid[i][j] + solve(grid, i + 1, j, row, column);
        } else {
            return t[i][j] = grid[i][j]
                    + Math.min(solve(grid, i, j + 1, row, column), solve(grid, i + 1, j, row, column));
        }

    }

    public int minPathSum(int[][] grid) {
        //BF
        int row = grid.length;
        int column = grid[0].length;
        t = new int[row + 1][column + 1];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return solve(grid, 0, 0, row, column);

    }
}
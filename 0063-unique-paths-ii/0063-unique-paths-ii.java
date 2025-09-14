class Solution {
    int[][] t;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //memo
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        t = new int[m + 1][n + 1];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return solve(obstacleGrid, 0, 0, m, n);
    }

    public int solve(int[][] obstacleGrid, int i, int j, int m, int n) {
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return t[i][j] = 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return t[i][j] = 1;
        }
        int right = solve(obstacleGrid, i, j + 1, m, n);
        int down = solve(obstacleGrid, i + 1, j, m, n);

        return t[i][j] = right + down;
    }
}
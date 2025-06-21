class Solution {

    private List<int[]> dir = new ArrayList<>();

    Solution() {
        dir.add(new int[] { 1, 0 });
        dir.add(new int[] { -1, 0 });
        dir.add(new int[] { 0, 1 });
        dir.add(new int[] { 0, -1 });
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;

        grid[i][j] = '$';

        for (int[] p : dir) {
            int i1 = i + p[0];
            int j1 = j + p[1];
            dfs(grid, i1, j1);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
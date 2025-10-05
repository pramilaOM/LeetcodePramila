class Solution {
     private int m, n;
    private int[][] heights;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;

        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // DFS from cells bordering the Pacific Ocean
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificReachable, heights[i][0]); // Left edge
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificReachable, heights[0][j]); // Top edge
        }

        // DFS from cells bordering the Atlantic Ocean
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlanticReachable, heights[i][n - 1]); // Right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlanticReachable, heights[m - 1][j]); // Bottom edge
        }

        // Find cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(newR, newC, visited, heights[r][c]);
        }
    }
}
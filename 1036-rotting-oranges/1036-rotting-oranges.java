class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue with all rotten oranges and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0; // No fresh oranges

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS - rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // rot it
                        queue.offer(new int[]{nx, ny});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
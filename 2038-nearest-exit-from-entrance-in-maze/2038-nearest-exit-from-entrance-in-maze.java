class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { entrance[0], entrance[1], 0 });
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.') {
                    // Check if it's an exit (border cell, not entrance)
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return dist + 1;
                    }
                    maze[nr][nc] = '+'; // mark as visited
                    queue.offer(new int[] { nr, nc, dist + 1 });
                }
            }
        }
        return -1;
    }
}

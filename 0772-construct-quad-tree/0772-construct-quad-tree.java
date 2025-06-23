
class Solution {
    boolean isAllSame(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }

        }
        return true;
    }

    Node solve(int[][] grid, int x, int y, int n) {
        if (isAllSame(grid, x, y, n)) {
            return new Node(grid[x][y] == 1, true);
        }
        Node topLeft = solve(grid, x, y, n / 2);
        Node topRight = solve(grid, x, y + n / 2, n / 2);
        Node bottomLeft = solve(grid, x + n / 2, y, n / 2);
        Node bottomRight = solve(grid, x + n / 2, y + n / 2, n / 2);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);

    }

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);

    }
}
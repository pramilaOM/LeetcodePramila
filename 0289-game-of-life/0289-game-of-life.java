class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < row && nc < col) {
                        if (Math.abs(board[nr][nc]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[r][c] = -1;
                }

                if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 2;
                }

            }
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] > 0) {
                    board[r][c] = 1;
                } else {
                    board[r][c] = 0;
                }
            }
        }

    }
}
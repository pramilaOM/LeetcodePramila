class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        int row = board.length;
        int column = board[0].length;

        // 1. Mark boundary-connected 'O' with '*'
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][column - 1] == 'O')
                boundaryDFS(board, i, column - 1);
        }

        for (int j = 0; j < column; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[row - 1][j] == 'O')
                boundaryDFS(board, row - 1, j);
        }

        // 2. Flip inner 'O' to 'X' and '*' back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*'; // mark as safe

        boundaryDFS(board, i - 1, j);
        boundaryDFS(board, i + 1, j);
        boundaryDFS(board, i, j - 1);
        boundaryDFS(board, i, j + 1);
    }
}

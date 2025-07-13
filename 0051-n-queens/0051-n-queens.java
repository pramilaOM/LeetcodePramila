class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize board with '.'
        for (char[] row : board)
            Arrays.fill(row, '.');

        // Start backtracking from row 0
        backtrack(0, board, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result,
                           Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag) {
        int n = board.length;

        if (row == n) {
            // Found a valid board
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d = row - col;
            int ad = row + col;

            if (cols.contains(col) || diag.contains(d) || antiDiag.contains(ad)) {
                continue; // Conflict, skip
            }

            // Place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(d);
            antiDiag.add(ad);

            backtrack(row + 1, board, result, cols, diag, antiDiag);

            // Backtrack
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(d);
            antiDiag.remove(ad);
        }
    }
}

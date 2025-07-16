class Solution {
    boolean isValidSubbox(char[][] board, int sr, int er, int sc, int ec) {
        Set<Character> set = new HashSet<>();
        for (int row = sr; row <=er; row++) {
            for (int col = sc; col <= ec; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);

            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        //row
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);

            }
        }
        //column
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);

            }
        }
        //grid
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidSubbox(board, row, row + 2, col, col + 2)) {
                    return false;
                }

            }
        }
        return true;

    }
}
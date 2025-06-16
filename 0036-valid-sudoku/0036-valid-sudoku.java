import java.util.HashSet;

class Solution {
    private boolean isValidSubBox(char[][] board, int sr, int er, int sc, int ec) {
        HashSet<Character> set = new HashSet<>();
        for (int row = sr; row <= er; row++) {
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
        // Validate rows
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
        }

        // Validate columns
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                set.add(ch);
            }
        }

        // Validate 3x3 sub-boxes
        for (int sr = 0; sr < 9; sr += 3) {
            for (int sc = 0; sc < 9; sc += 3) {
                if (!isValidSubBox(board, sr, sr + 2, sc, sc + 2)) {
                    return false;
                }
            }
        }

        return true;
    }
}

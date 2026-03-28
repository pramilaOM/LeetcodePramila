class Solution {
    public boolean isValidSudoku(char[][] board) {
        //https://www.youtube.com/watch?v=dGZjzA9zLW8 
        //optimized
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                String row = board[i][j] + "_row_" + i;
                String col = board[i][j] + "_col_" + j;
                String box = board[i][j] + "_box_" + (i / 3) + "_" + (j / 3);

                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}
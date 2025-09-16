class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                String rowKey = String.valueOf(board[i][j]) + "_row_" + i;
                String columnKey = String.valueOf(board[i][j]) + "_col_" + j;
                String subBox = String.valueOf(board[i][j]) + (i / 3) + "_box_" + (j / 3);

                if (set.contains(rowKey) || set.contains(columnKey) || set.contains(subBox)) {
                    return false;
                }
                set.add(rowKey);
                set.add(columnKey);
                set.add(subBox);
            }
        }
        return true;

    }
}
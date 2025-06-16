class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.')
                    continue;

                String rowKey = num + "_row_" + i;
                String colKey = num + "_col_" + j;
                String boxKey = num + "_row_" + (i / 3) + "_" + (j / 3);

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);

            }
        }
        return true;

    }
}
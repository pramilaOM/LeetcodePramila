class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return count;
    }

    void backtrack(int row, int n, Set<Integer> cols, Set<Integer> d1, Set<Integer> d2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int do1 = row - col;
            int do2 = row + col;

            if (cols.contains(col) || d1.contains(do1) || d2.contains(do2)) {
                continue;
            }
            cols.add(col);
            d1.add(do1);
            d2.add(do2);

            backtrack(row + 1, n, cols, d1, d2);
            cols.remove(col);
            d1.remove(do1);
            d2.remove(do2);
        }
    }
}
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for (int r = 0; r < n; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                row.add(grid[r][c]);
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        for (int c = 0; c < n; c++) {
            List<Integer> col = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                col.add(grid[r][c]);
            }
            count += rowMap.getOrDefault(col, 0);

        }
        return count;
    }
}

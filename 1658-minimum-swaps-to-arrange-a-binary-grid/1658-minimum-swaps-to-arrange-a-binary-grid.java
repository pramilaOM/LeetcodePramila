class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zeros[i] = count;
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int need = n - 1 - i;

            int found = -1;
            for (int j = i; j < n; j++) {
                if (zeros[j] >= need) {
                    found = j;
                    break;
                } 
            }

            if (found == -1) return -1;

            for (int j = found; j > i; j--) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                swaps++;
            }
        }

        return swaps;
    }
}
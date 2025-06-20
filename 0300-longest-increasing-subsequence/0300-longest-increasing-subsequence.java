class Solution {
    int n;
    int[][] t;

    int lis(int[] nums, int p, int c) {
        if (c == n)
            return 0;

        if (p != -1 && t[p][c] != -1)
            return t[p][c];

        int taken = 0;
        if (p == -1 || nums[c] > nums[p]) {
            taken = 1 + lis(nums, c, c + 1);
        }

        int notTaken = lis(nums, p, c + 1);

        if (p != -1) {
            t[p][c] = Math.max(taken, notTaken);
        }

        return Math.max(taken, notTaken);
    }

    public int lengthOfLIS(int[] nums) {
        t = new int[2501][2501];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        n = nums.length;
        return lis(nums, -1, 0);
    }
}
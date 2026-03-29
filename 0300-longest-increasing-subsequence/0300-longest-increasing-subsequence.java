class Solution {
    int[][] t = new int[2501][2501];

    int solve(int[] nums, int i, int prev) {
        if (i >= nums.length) {
            return 0;
        }

        if (prev != -1 && t[i][prev] != -1) {
            return t[i][prev];
        }
        int take = 0;

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(nums, i + 1, i);
        }
        int skip = solve(nums, i + 1, prev);
        if (prev != -1) {
            t[i][prev] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        for (int arr[] : t) {
            Arrays.fill(arr, -1);

        }
        return solve(nums, 0, -1);

    }
}
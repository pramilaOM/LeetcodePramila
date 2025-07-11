class Solution {
    int[] dp = new int[401];

    int solve(int[] nums, int currentIndex) {
        if (currentIndex == nums.length - 1) {
            dp[currentIndex] = nums[currentIndex];
            return dp[currentIndex];
        } else if (currentIndex > nums.length - 1) {
            return 0;
        }

        if (dp[currentIndex] != -1) {
            return dp[currentIndex];
        }
        int rob = solve(nums, currentIndex + 2);
        int noRob = solve(nums, currentIndex + 1);
        dp[currentIndex] = Math.max(rob + nums[currentIndex], noRob);
        return dp[currentIndex];
    }

    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
}
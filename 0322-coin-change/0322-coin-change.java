class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -2;
        }

        int ans = solve(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -2) {
            return dp[amount];
        }

        int mini = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = solve(coins, amount - coin, dp);

            if (res != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + res);
            }
        }

        dp[amount] = mini;
        return dp[amount];
    }
}
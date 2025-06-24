class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n == 0)
            return 0;

        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int max = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + max);
                max = Math.max(max, dp[t - 1][d] - prices[d]);
            }
        }
        return dp[k][n - 1];
    }
}
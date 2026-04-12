class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int i = 0; i < n - 1; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < n; j++) {
                int sell = prices[j];
                profit = Math.max(profit, sell - buy);

            }

        }
        return profit;
    }
}
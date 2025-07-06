class Solution {
    public int maxProfit(int[] prices, int fee) {
        // \U0001f9e0 DP with greedy update
        // hold = max profit when holding a stock
        // cash = max profit when not holding a stock
        int hold = -prices[0];  // buy on day 0
        int cash = 0;           // no stock, no profit

        for (int i = 1; i < prices.length; i++) {
            // sell today or do nothing
            cash = Math.max(cash, hold + prices[i] - fee);
            // buy today or do nothing
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}

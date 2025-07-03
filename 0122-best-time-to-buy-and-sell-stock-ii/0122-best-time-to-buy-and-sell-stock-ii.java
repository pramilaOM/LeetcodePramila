class Solution {
    public int maxProfit(int[] prices) {
        //Need to learn DP approach
        //https://www.youtube.com/watch?v=Q7v239y-Tik
        //TC O(n) Single pass over array
        //SC O(1) No extra memory used
        // greedy optimized solution
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
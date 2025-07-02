class Solution {
    public int maxProfit(int[] prices) {
        // Optimized Approach — One Pass (Kadane-like idea)
        // Time Complexity:
        // O(n) — single pass through array

        // \U0001f9e0 Space Complexity:
        // O(1) — constant space

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            int currProfit = prices[i]-minPrice;
            if(currProfit > maxProfit){
                maxProfit = currProfit;
            }
        }
        return maxProfit;
      
    }
}
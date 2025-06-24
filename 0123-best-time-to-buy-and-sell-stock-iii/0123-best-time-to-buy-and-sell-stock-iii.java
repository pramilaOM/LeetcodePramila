class Solution {
    public int maxProfit(int[] prices) {

        int b1 = Integer.MIN_VALUE;
        int s1 = 0;
        int b2 = Integer.MIN_VALUE;
        int s2 = 0;

        for (int price : prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;

    }
}
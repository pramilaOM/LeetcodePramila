class Solution {
    public int minStartValue(int[] nums) {

        int PrefixSum = 0;
        int minValue = Integer.MAX_VALUE;
        for (int n : nums) {
            PrefixSum += n;
            minValue = Math.min(minValue, PrefixSum);
        }

        return Math.max(1, (1 - minValue));
    }
}
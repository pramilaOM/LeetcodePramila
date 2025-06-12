class Solution {
    public int subarraySum(int[] nums) {
        int subarraysum = 0;
        int[] PrefixSum = new int[nums.length + 1];
        PrefixSum[0] = 0;
        for (int i = 1; i < PrefixSum.length; i++) {
            PrefixSum[i] = PrefixSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            subarraysum = PrefixSum[i + 1] - PrefixSum[start] + subarraysum;

        }

        return subarraysum;
    }
}
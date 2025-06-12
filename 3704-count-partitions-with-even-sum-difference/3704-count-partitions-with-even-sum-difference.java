class Solution {
    public int countPartitions(int[] nums) {
        int evenDiff = 0;
        int[] PrefixSum = new int[nums.length];
        PrefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            PrefixSum[i] = PrefixSum[i - 1] + nums[i];
        }
        int last = PrefixSum[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            int ans = PrefixSum[i] - (last - PrefixSum[i]);
            if (ans % 2 == 0) {
                evenDiff++;
            }
        }

        return evenDiff;

    }
}
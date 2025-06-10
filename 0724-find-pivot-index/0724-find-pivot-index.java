class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftPrefixSum = new int[n];
        int[] rightPrefixSum = new int[n];
        leftPrefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftPrefixSum[i] = leftPrefixSum[i - 1] + nums[i];
        }

        rightPrefixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightPrefixSum[i] = rightPrefixSum[i + 1] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (leftPrefixSum[i] == rightPrefixSum[i]) {
                ans = i;
                break;
            } else {
                ans = -1;
            }
        }
        return ans;
    }
}
class Solution {
    int kadanesMax(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    int kadanesMin(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int maxSum = kadanesMax(nums);
        int minSum = kadanesMin(nums);

        int circularSum = totalSum - minSum;

        if (maxSum > 0) {
            return Math.max(maxSum, circularSum);
        }

        return maxSum;
    }
}
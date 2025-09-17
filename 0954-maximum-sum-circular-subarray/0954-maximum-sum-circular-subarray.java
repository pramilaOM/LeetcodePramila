class Solution {

    private int kadanesMax(int[] nums) {
        int curr = nums[0], best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            best = Math.max(best, curr);
        }
        return best;
    }

    private int kadanesMin(int[] nums) {
        int curr = nums[0], best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.min(curr + nums[i], nums[i]);
            best = Math.min(best, curr);
        }
        return best;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int total = 0;
        for (int x : nums)
            total += x;

        int minSum = kadanesMin(nums);
        int maxSum = kadanesMax(nums);

        int circSum = total - minSum;

        if (maxSum > 0)
            return Math.max(maxSum, circSum);
        return maxSum;

    }
}
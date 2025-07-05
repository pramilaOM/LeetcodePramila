class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j = 0, sum = 0;
        double maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for (j = 0; j < n; j++) {
            sum += nums[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i];
                i++;
            }

        }
        return maxSum / k;
    }
}
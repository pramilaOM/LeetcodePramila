class Solution {
    public int[] leftRightDifference(int[] nums) {
         int n = nums.length;
        int[] left = new int[n];
        int[] diff = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        int rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            diff[i] = Math.abs(left[i] - rightSum);
            rightSum += nums[i];
        }

        return diff;
    }
}
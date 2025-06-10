class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = totalSum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxReachable = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, nums[i] + i);

        }
        return true;

    }
}
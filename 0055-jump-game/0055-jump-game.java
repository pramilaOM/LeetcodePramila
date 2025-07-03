class Solution {
    int[] memo = new int[10001];
    public boolean canJump(int[] nums) {
        Arrays.fill(memo,-1);//-1 unvisited , 1 visited 
        int len = nums.length;
        return solve(nums, len, 0);

    }

    private boolean solve(int[] nums, int len, int index) {

        if (index == len - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }

        if(memo[index] != -1){
            return memo[index] == 1;
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (solve(nums, len, index + i) == true) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return false;
    }

}
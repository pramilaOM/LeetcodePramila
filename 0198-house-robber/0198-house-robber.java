class Solution {
    int[] t = new int[101];

    int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if(t[index] != -1){
            return t[index];
        }

        int take = nums[index] + solve(nums, index + 2);
        int skip = solve(nums, index + 1);

        return t[index] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        Arrays.fill(t, -1);
        return solve(nums, 0);

    }
}
class Solution {

    int[] t = new int[401];
    int solve(int[] nums, int index) {

        if(index >= nums.length){
            return 0; 
        }

        if(t[index] != -1){
            return t[index];
        }


        int steal = nums[index] + solve(nums, index + 2);
        int skip = solve(nums, index + 1);

        return t[index] =Math.max(steal, skip);

    }

    public int rob(int[] nums) {
        int len = nums.length;
        int index = 0;
        Arrays.fill(t,-1);
        return solve(nums, index);
    }
}
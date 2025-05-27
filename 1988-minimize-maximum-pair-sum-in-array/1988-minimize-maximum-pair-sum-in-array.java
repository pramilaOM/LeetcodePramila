class Solution {
    public int minPairSum(int[] nums) {

     int n = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            result = Math.max(result, nums[i] + nums[n - 1 - i]);

        }

        return result;    
    }

}
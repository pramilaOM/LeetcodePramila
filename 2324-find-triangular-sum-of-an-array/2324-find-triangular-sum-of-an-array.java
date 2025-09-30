class Solution {
    public int triangularSum(int[] nums) {
         while (nums.length > 1) {
            int[] temp = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                temp[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = temp; // No std::move in Java; reassignment just points nums to new array
        }
        return nums[0];
        
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int left = 0;
        for(int i = 0;i<n;i++){
            int right = totalSum - left - nums[i];
            if(left == right){
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int low =0;
        int high = 0;
        int minLenWindow = Integer.MAX_VALUE;
        for(high = 0;high <nums.length;high++){
            currentSum+=nums[high];
            while(currentSum >= target){
                int currrentWindow = high-low+1;
                minLenWindow = Math.min(minLenWindow,currrentWindow);
                currentSum= currentSum-nums[low];
                low++;
            }
        }
        return minLenWindow== Integer.MAX_VALUE?0:minLenWindow;
        
    }
}
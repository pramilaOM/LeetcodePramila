class Solution {
    public int maxAdjacentDistance(int[] nums) {
        
        int n = nums.length;
        int diff = 0;
        for (int i = 0; i < n ; i++) {
                int nextIndex = (i+1)%n;
                int newdiff = Math.abs(nums[i] - nums[nextIndex]);
                diff = Math.max(diff,newdiff);
        }
        return diff;
        
    }
    
}
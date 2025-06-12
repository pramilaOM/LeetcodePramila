class Solution {
    public int maxAdjacentDistance(int[] nums) {
        
        int n = nums.length;
        int diff = Math.abs(nums[0]-nums[n-1]);
        for (int i = 0; i < n - 1; i++) {
                int first = nums[i];
                int second = nums[i + 1];
                int newdiff = Math.abs(first - second);
                diff = Math.max(diff,newdiff);
        }
        return diff;
        
    }
    
}
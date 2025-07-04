class Solution {
    int[] memo = new int[10001];
    public int jump(int[] nums) {
         // BF
        // Time Complexity: O(nⁿ) in the worst case (since it tries all jump paths
        // recursively)
        // Space Complexity: O(n) due to recursion stack depth
        Arrays.fill(memo,-1);
        return solve(nums, nums.length, 0);
    }
     private  int solve(int[] nums, int length, int i) {
        // base case last index
        if (i == length - 1) {
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        int minJump = Integer.MAX_VALUE;
        // From index i, try every position from i+1 to i+nums[i]
        for (int next = i + 1; next <= i + nums[i] && next < length; next++) {
            // Recursively find the minimum jumps needed from each of those positions
            int subroute = solve(nums, length, next);
            if (subroute != Integer.MAX_VALUE) {
                // Add 1 for the current jump
                minJump = Math.min(1 + subroute, minJump);
            }
        }
        memo[i]= minJump;
        return minJump;
    }

}
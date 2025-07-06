class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // Base case: the first two steps can be taken directly
        int prev2 = cost[0]; // Cost to reach step 0
        int prev1 = cost[1]; // Cost to reach step 1

        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }

        // The top can be reached either from the last step or the second last
        return Math.min(prev1, prev2);
    }
}

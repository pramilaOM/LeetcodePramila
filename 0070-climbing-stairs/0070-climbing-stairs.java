class Solution {

    int solve(int step, int last) {

        if (step == last) {
            return 1;
        } else if (step > last) {
            return 0;
        }

        return solve(step + 1, last) + solve(step + 2, last);

    }

    public int climbStairs(int n) {

        return solve(0, n);

    }
}
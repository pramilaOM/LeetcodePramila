class Solution {
    //memoized Top down
    int[] t = new int[46];

    private int solve(int n) {
        if (n < 0) {
            return 0;
        }
        if(t[n] != -1){
            return t[n];
        }
        if (n == 0) {
            return 1;
        }

        int oneStep = solve(n - 1);
        int twoStep = solve(n - 2);

        return t[n] = oneStep + twoStep;

    }

    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }
}
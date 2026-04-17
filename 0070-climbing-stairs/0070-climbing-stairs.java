class Solution {
    int[] t = new int[46];

    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }

    int solve(int n) {
        if (n == 1 || n == 2 || n == 3)
            return n;

        if (t[n] != -1)
            return t[n];

        int stepOne = solve(n - 1);
        int stepTwo = solve(n - 2);

        return t[n] = stepOne + stepTwo;
    }
}
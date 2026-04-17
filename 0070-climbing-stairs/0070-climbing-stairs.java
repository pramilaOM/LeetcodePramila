class Solution {
    int[] t = new int[46];

    public int climbStairs(int n) {
        if (n == 1 || n == 2 || n == 3) {
            t[n] = n;
            return t[n];
        }

        Arrays.fill(t, -1);

        if (t[n] != -1) {
            return t[n];
        }
        int stepOne = climbStairs(n - 1);
        int stepTwo = climbStairs(n - 2);

        return t[n] = stepOne + stepTwo;

    }
}
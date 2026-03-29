class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] t = new int[amount + 1];
        Arrays.fill(t, -1);
        int res = solve(coins, amount, t);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int solve(int[] coins, int amount, int[] t) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (t[amount] != -1) {
            return t[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, amount - coin, t);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + res);
            }

        }
        return t[amount] = ans;
    }
}
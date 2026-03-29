class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;

        int[] minCoins = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }
        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];

    }
}
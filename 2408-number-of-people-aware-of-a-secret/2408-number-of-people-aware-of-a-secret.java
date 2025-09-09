class Solution {
    int MOD = 1_000_000_007;
    int n, delay, forget;
    int[] t;

    private int solve(int day) {
        if (day == 1)
            return 1;
        if (day <= 0)
            return 0;
        if (t[day] != -1)
            return t[day];

        long result = 0;
        for (int prev = day - forget + 1; prev <= day - delay; prev++) {
            if (prev > 0) {
                result = (result + solve(prev)) % MOD;
            }
        }
        return t[day] = (int) result;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        this.n = n;
        this.delay = delay;
        this.forget = forget;
        t = new int[n + 1];
        Arrays.fill(t, -1);
        int total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                total = (total + solve(day)) % MOD;
            }
        }
        return total;
    }
}
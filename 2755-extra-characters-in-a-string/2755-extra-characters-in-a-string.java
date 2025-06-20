class Solution {
    int n;
    int[] dp;
    Set<String> dict;

    int solve(String s, int i) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int min = 1 + solve(s, i + 1);

        for (int j = i; j < n; j++) {
            String sub = s.substring(i, j + 1);
            if (dict.contains(sub)) {
                min = Math.min(min, solve(s, j + 1));
            }
        }

        return dp[i] = min;

    }

    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        dict = new HashSet<>(Arrays.asList(dictionary));
        return solve(s, 0);

    }
}
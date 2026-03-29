class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = dp[i] || (dp[i - k] && wordSet.contains(s.substring(i - k, i)));
            }
        }
        return dp[s.length()];
    }
}
class Solution {
    int n;
    private Boolean[] t;

    boolean solve(String s, int idx, List<String> wordDict) {
        if (idx == n) {
            return true;
        }

        if (t[idx] != null) {
            return t[idx];
        }

        for (int end = idx + 1; end <= n; end++) {
            String split = s.substring(idx, end);

            if (wordDict.contains(split) && solve(s, end, wordDict)) {
                return t[idx] = true;
            }
        }
        return t[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        t = new Boolean[n];
        return solve(s, 0, wordDict);

    }
}
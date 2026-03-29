class Solution {
    Boolean[] t = new Boolean[301];

    boolean solve(String s, List<String> wordDict, int idx) {

        if (idx == s.length()) {
            return t[idx] = true;

        }

        if (t[idx] != null) {
            return t[idx];
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (wordDict.contains(sub) && solve(s, wordDict, i)) {
                return t[idx] = true;
            }
        }

        return t[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, 0);
    }
}
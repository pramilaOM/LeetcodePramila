class Solution {
    //memo 
    Boolean[] t;

    boolean solve(String s, int idx, List<String> wordDict) {
        if (idx == s.length()) {
            return true;
        }

        if (t[idx] != null) {
            return t[idx];
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            String split = s.substring(idx, i);
            if (wordDict.contains(split) && solve(s, i, wordDict)) {
                return t[idx] = true;
            }
        }
        return t[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        t = new Boolean[s.length()];
        return solve(s, 0, wordDict);
    }
}
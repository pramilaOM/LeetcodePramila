class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        int maxL = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && (t[i + 1][j - 1] || l == 2)) {
                    t[i][j] = true;
                    if (l > maxL) {
                        maxL = l;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxL);
    }
}
class Solution {

    int solve(String word1, String word2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = i + j;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(Math.min(t[i][j - 1], t[i - 1][j]), t[i - 1][j - 1]);
                    ;
                }

            }
        }
        return t[m][n];

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        return solve(word1, word2, m, n);

    }
}
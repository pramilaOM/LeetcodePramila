class Solution {

    int solve(String word1, String word2, int m, int n,int[][] t) {
        if (m == 0 || n == 0) {
            return t[m][n] = m + n;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return t[m][n] = solve(word1, word2, m - 1, n - 1,t);
        } else {
            int insert = 1 + solve(word1, word2, m, n - 1,t);
            int delete = 1 + solve(word1, word2, m - 1, n,t);
            int replace = 1 + solve(word1, word2, m - 1, n - 1,t);

            return t[m][n] = Math.min(Math.min(insert, delete), replace);
        }

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] t = new int[m+1][n+1];
        for (int[] pok : t) {
            Arrays.fill(pok, -1);
        }
        return solve(word1, word2, m, n, t);

    }
}
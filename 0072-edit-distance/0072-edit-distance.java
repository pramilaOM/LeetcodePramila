class Solution {

    //bf
    int[][] t;

    public int solve(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return n + m;
        }

        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return t[m][n] = solve(s1, s2, m - 1, n - 1);
        }

        int insert = 1 + solve(s1, s2, m, n - 1);
        int delete = 1 + solve(s1, s2, m - 1, n);
        int replace = 1 + solve(s1, s2, m - 1, n - 1);

        return t[m][n] = Math.min(Math.min(insert, delete), replace);

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        t = new int[m+1][n+1];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return solve(word1, word2, m, n);
    }
}
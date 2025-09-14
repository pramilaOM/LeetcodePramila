class Solution {
    //memo
    int m, n, p;
    int[][][] t;

    public boolean solve(int i, int j, int k, String s1, String s2, String s3) {
        if (i == m && j == n && k == p) {
            return true;
        }

        if (t[i][j][k] != -1) {
            return t[i][j][k] == 1;
        }

        if (k >= p) {
            return false;
        }

        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3);
        }

        if (result == true) {
            return true;
        }
        if (j < n && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3);
        }
        t[i][j][k] = result ? 1 : 0;
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        p = s3.length();
        if (m + n != p) {
            return false;
        }

        t = new int[m + 1][n + 1][p + 1];
        for (int[][] arr : t) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        return solve(0, 0, 0, s1, s2, s3);
    }
}
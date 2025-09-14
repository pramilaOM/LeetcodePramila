class Solution {
    //bf
    int m, n;

    public boolean solve(int i, int j, String s1, String s2, String s3) {
        if (i == m && j == n) {
            return true;
        }
        boolean result = false;
        if (i < m && s1.charAt(i) == s3.charAt(i+j)) {
            result = solve(i + 1, j, s1, s2, s3);
        }
        if(result == true){
            return true;
        }
        if (j < n && s2.charAt(j) == s3.charAt(i+j)) {
            result = solve(i, j + 1, s1, s2, s3);
        }
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        return solve(0, 0, s1, s2, s3);
    }
}
class Solution {
    //BF
    int t[][];

    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
             t[i][j] = isPalindrome(s, i + 1, j - 1) ? 1 : 0;
        }else{
            t[i][j] = 0;
        }
        return t[i][j] == 1;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int startIndex = 0;
        t = new int[n][n];
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
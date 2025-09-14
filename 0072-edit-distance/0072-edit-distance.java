class Solution {

    int m, n;
    //memo
    int[][] t;
    public int solve(String s1, String s2, int i, int j) {
        if (i == m) {
            return n - j;
        } else if (j == n) {
            return m - i;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return  solve(s1, s2, i + 1, j + 1);
        }

        int insert = 1 + solve(s1, s2, i, j + 1);
        int delete = 1 + solve(s1, s2, i + 1, j);
        int replace = 1 + solve(s1, s2, i + 1, j + 1);

        return t[i][j]=Math.min(Math.min(insert, delete), replace);

    }

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        t = new int[m+1][n+1];
        for(int[] arr: t){
            Arrays.fill(arr,-1);
        }
        return solve(word1, word2, 0, 0);
    }
}
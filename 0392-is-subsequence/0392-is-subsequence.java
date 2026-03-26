class Solution {
    public boolean isSubsequence(String s, String t) {
        //http://youtube.com/watch?v=r51_ZifUdvU
        int m = s.length();
        int n = t.length();
        int start = 0, end = 0;

        while (start < m && end < n) {
            if (s.charAt(start) == t.charAt(end)) {
                start++;
            }
            end++;

        }
        if (start == m) {
            return true;
        }
        return false;
    }
}
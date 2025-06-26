class Solution {
    public int longestSubsequence(String s, int k) {
        int length = 0;
        long powerValue = 1;

        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '0') {
                length++;
            } else if (powerValue <= k) {
                length++;
                k -= powerValue;
            }

            if (powerValue <= k) {
                powerValue <<= 1; // powerValue *= 2
            }
        }

        return length;
    }
}
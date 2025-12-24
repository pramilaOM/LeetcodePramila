class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        int[] lps = buildLPS(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    //kmp
    private int[] buildLPS(String needle) {
        int n = needle.length();
        int[] lps = new int[n];

        int length = 0;
        int i = 1;

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length > 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
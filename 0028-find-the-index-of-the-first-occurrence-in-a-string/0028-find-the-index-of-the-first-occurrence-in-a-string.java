class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int index = 0;
            while (index < n) {
                if (haystack.charAt(i + index) != needle.charAt(index)) {
                    break;
                }else{
                     index++;
                }
               

            }
            if (index == n) {
                return i;
            }
        }
        return -1;
    }
}
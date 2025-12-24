class Solution {
    public int strStr(String haystack, String needle) {
        //bf

        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            int index = 0;
            while (index < needle.length()) {
                if (haystack.charAt(i + index) != needle.charAt(index)) {
                    break;
                }
                index++;
            }
            if (index == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
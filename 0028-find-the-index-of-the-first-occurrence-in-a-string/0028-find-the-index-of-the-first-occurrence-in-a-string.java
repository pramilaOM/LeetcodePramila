class Solution {
    public int strStr(String haystack, String needle) {
        //bf
        if(needle.length() > haystack.length()){
            return -1;
        }
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
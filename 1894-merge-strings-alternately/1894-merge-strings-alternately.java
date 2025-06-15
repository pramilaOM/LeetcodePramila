class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ptr1 = 0, ptr2 = 0;
        StringBuilder result = new StringBuilder();

        while (ptr1 < word1.length() || ptr2 < word2.length()) {
            if (ptr1 < word1.length()) {
                result.append(word1.charAt(ptr1));
                ptr1++;
            }
            if (ptr2 < word2.length()) {
                result.append(word2.charAt(ptr2));
                ptr2++;
            }
        }
        return result.toString();
    }
}
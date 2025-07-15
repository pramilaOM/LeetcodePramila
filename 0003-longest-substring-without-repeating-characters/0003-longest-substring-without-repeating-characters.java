class Solution {
    public int lengthOfLongestSubstring(String s) {
        //bf
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            Set<Character> unique = new HashSet<>();
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (unique.contains(c)) {
                    break;
                }
                unique.add(c);
                maxLen = Math.max(maxLen, j - i + 1);

            }
        }
        return maxLen;

    }
}
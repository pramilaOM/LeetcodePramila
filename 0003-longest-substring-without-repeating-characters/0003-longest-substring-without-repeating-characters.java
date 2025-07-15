class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> unique = new HashSet<>();
        int maxLen = 0;
        int left = 0, right = 0;
        while (right < len) {
            char c = s.charAt(right);
            if (unique.contains(c)) {
                unique.remove(s.charAt(left));
                left++;
            } else {
                unique.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }

        }

        return maxLen;
    }
}
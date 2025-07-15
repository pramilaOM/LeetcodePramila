class Solution {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        // Step 1: Build frequency map for t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Initialize sliding window and tracking variables
        Map<Character, Integer> windowMap = new HashMap<>();
        int required = targetMap.size(); // number of unique characters required
        int formed = 0; // number of unique characters that meet requirement

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0; // to track start of min window

        // Step 3: Expand window with right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If character is in t and meets required frequency
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Step 4: Try to contract from the left while valid
            while (formed == required) {
                // Update minLen and startIdx if smaller window found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                // Remove the leftmost character from window
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If it's in target and below required frequency, decrease formed
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }

                left++; // shrink window
            }

            right++; // expand window
        }

        // Step 5: Return result
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }

}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currCharacter = s.charAt(end);
            if (map.containsKey(currCharacter)) {
                start = Math.max(start, map.get(currCharacter) + 1);

            }
            map.put(currCharacter, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;

    }
}
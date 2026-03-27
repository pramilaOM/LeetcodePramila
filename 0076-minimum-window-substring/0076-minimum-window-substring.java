class Solution {
    public String minWindow(String s, String t) {
        //https://www.youtube.com/watch?v=3Bp3OVD1EGc

        int n = s.length();

        if (t.length() > n)
            return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int requiedCount = t.length();
        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) > 0)
                requiedCount--;

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (requiedCount == 0) {
                int currWindowSize = j - i + 1;

                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                map.put(startChar, map.getOrDefault(startChar, 0) + 1);

                if (map.containsKey(startChar) && map.get(startChar) > 0) {
                    requiedCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);

    }
}
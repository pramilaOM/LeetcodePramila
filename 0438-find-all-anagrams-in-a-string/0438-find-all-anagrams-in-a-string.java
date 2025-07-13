class Solution {
    public List<Integer> findAnagrams(String s, String p) {
                List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Build pCount and first window sCount
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Slide window
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pCount, sCount)) {
                result.add(i);
            }

            // Move window: remove leftmost char and add new right char
            if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--;                         // Remove
                sCount[s.charAt(i + p.length()) - 'a']++;           // Add
            }
        }

        return result;
    }
}
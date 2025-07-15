class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
                List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int L = words[0].length(); // Length of each word
        int N = words.length; // Number of words

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try every offset within word length
        for (int i = 0; i < L; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + L <= s.length()) {
                String word = s.substring(right, right + L);
                right += L;

                if (wordCount.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if word frequency is too high
                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + L);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += L;
                    }

                    // If valid window found
                    if (count == N) {
                        result.add(left);
                    }
                } else {
                    // Invalid word, reset window
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
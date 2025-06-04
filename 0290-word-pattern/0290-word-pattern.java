class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<String, Integer> wordToIndex = new HashMap<>();

        String[] words = s.split(" ");
        int countTokens = words.length;
        int n = pattern.length();

        if (countTokens != n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            int charIndex = charToIndex.getOrDefault(c, 0);
            int wordIndex = wordToIndex.getOrDefault(word, 0);

            if (charIndex != wordIndex) {
                return false;
            }
            charToIndex.put(c, i + 1);
            wordToIndex.put(word, i + 1);

        }
        return true;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();

        if (words.length != n)
            return false;

        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<String, Integer> wordToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!Objects.equals(charToIndex.getOrDefault(ch, 0), wordToIndex.getOrDefault(word, 0))) {
                return false;
            }
            charToIndex.put(ch, i + 1);
            wordToIndex.put(word, i + 1);
        }
        return true;
    }
}
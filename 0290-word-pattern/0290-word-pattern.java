class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();

        if (words.length != n)
            return false;

        Map<String, Character> wordToChar = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);

            if (!wordToChar.containsKey(word) && !usedChars.contains(ch)) {
                wordToChar.put(word, ch);
                usedChars.add(ch);
            } else if (!Objects.equals(wordToChar.get(word), ch)) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        int n = pattern.length();

        if (words.length != n) {
            return false;
        }

        Map<String, Character> wordToChar = new HashMap<>();
        Set<Character> charUsed = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];
            char ch = pattern.charAt(i);

            if (!wordToChar.containsKey(word)) {
                if (charUsed.contains(ch)) {
                    return false;
                }
                wordToChar.put(word, ch);
                charUsed.add(ch);
            } else {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            }

        }
        return true;

    }
}
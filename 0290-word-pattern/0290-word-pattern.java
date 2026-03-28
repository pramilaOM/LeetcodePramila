class Solution {
    public boolean wordPattern(String pattern, String s) {
        //https://www.youtube.com/watch?v=n0cn5tJwkaE
        //https://www.youtube.com/watch?v=b_pNf56VIqY
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        HashMap<String, Integer> wordToIndex = new HashMap<>();

        String[] words = s.split(" ");
        int n = pattern.length();

        if (words.length != n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            int charIndex = charToIndex.getOrDefault(ch, 0);
            int wordIndex = wordToIndex.getOrDefault(word, 0);

            if (charIndex != wordIndex) {
                return false;
            }

            charToIndex.put(ch, i + 1);
            wordToIndex.put(word, i + 1);
        }

        return true;
    }
}
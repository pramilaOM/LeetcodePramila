class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        boolean hasConsonent = false, hasVowel = false;
        if (n < 3) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (isVowel(ch)) {
                hasVowel = true;
            } else if (Character.isLetter(ch)) {
                hasConsonent = true;
            }
        }
        return hasVowel && hasConsonent;
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
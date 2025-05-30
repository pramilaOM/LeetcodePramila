class Solution {
    public boolean detectCapitalUse(String word) {

        return check(word, 'A', 'Z') || check(word, 'a', 'z')
                || (word.length() > 1 && check(word.substring(1), 'a', 'z'));

    }

    public static boolean check(String word, char start, char end) {
        for (char c : word.toCharArray()) {
            if (c < start || c > end) {
                return false;
            }

        }
        return true;

    }

    public static boolean allSmall(String word) {
        for (char c : word.toCharArray()) {
            if (c < 'a' || c > 'z') {
                return false;
            }

        }
        return true;

    }
}
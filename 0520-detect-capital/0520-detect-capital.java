class Solution {
    public boolean detectCapitalUse(String word) {

        return allCapital(word) || allSmall(word) || allSmall(word.substring(1));

    }

    public static boolean allCapital(String word) {
        for (char c : word.toCharArray()) {
            if (c < 'A' || c > 'Z') {
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
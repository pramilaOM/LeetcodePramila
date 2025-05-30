class Solution {
    public boolean detectCapitalUse(String word) {

        int uppercount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercount++;
            }
        }

        return uppercount == word.length() || uppercount == 0
                || (uppercount == 1 && Character.isUpperCase(word.charAt(0)));

    }

}
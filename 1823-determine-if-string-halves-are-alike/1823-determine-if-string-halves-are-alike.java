class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String s1 = s.substring(0, n / 2);
        String s2 = s.substring(n / 2, n);
        int countVowelS1 = 0;
        int countVowelS2 = 0;
        for (char c : s1.toCharArray()) {
            if (isVowel(c)) {
                countVowelS1 += 1;
            }
        }
        for (char c : s2.toCharArray()) {
            if (isVowel(c)) {
                countVowelS2 += 1;
            }

        }
        return countVowelS1 == countVowelS2;

    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        } else {
            return false;
        }
    }

}
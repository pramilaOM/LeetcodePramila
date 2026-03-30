class Solution {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] countEven = new int[26];
        int[] countOdd = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (i % 2 == 0) {
                countEven[c1 - 'a']++;
                countEven[c2 - 'a']--;
            } else {
                countOdd[c1 - 'a']++;
                countOdd[c2 - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (countEven[i] != 0 || countOdd[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) {
                count++;
            }
            if (j >= k && isVowel(s.charAt(j - k))) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
class Solution {
    public int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxCons = 0;

        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;

            if ("aeiou".indexOf(ch) != -1) { // check if vowel
                maxVowel = Math.max(maxVowel, arr[ch - 'a']);
            } else { // consonant
                maxCons = Math.max(maxCons, arr[ch - 'a']);
            }
        }

        return maxCons + maxVowel;
    }
}
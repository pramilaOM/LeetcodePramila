class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Create a frequency count array freq[26] for characters in magazine.
        int[] freq = new int[26];
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }
        // Iterate over ransomNote:
        for (char ran : ransomNote.toCharArray()) {
            // For each character, check if it's available in freq[].
            if (freq[ran -'a'] == 0) {
                return false;
            }
            // If yes, decrement count.
            freq[ran - 'a']--;
            // If not, return false.
        }

        // If all characters are available in the required quantity → return true.
        return true;
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder mag = new StringBuilder(magazine);

        for (char ch : ransomNote.toCharArray()) {
            int index = mag.indexOf(String.valueOf(ch)); // find first occurrence
            if (index == -1) {
                return false; // character not found
            }
            mag.deleteCharAt(index); // remove used character
        }

        return true;
    }
}
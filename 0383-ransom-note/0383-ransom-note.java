class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //bf
        StringBuilder mag = new StringBuilder(magazine);
        // For each character in ransomNote
        for (char ran : ransomNote.toCharArray()) {
            // Scan the entire magazine string to find and remove the first occurrence of
            // that character.
            int index = mag.indexOf(String.valueOf(ran));
            // If not found → return false
            if (index == -1) {
                return false;
            }
            mag.deleteCharAt(index);

        }

        return true;
    }
}
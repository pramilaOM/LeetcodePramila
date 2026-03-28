class Solution {
    public boolean isAnagram(String s, String t) {
        //https://www.youtube.com/watch?v=1tmEKyRAMuY
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Check if all elements in the array are 0
        boolean allZeros = Arrays.stream(count).allMatch(element -> element == 0);

        return allZeros;
    }
}
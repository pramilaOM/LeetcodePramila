class Solution {
    public boolean isAnagram(String s, String t) {
        //https://www.youtube.com/watch?v=1tmEKyRAMuY
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
}
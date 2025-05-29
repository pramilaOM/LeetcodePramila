class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String s1 = "";
        String s2 = "";
        for (String s : word1) {
            s1 += s;
        }
        for (String second : word2) {
            s2 += second;
        }
        
        return s1.equals(s2);
    }
}
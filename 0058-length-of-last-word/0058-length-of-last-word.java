class Solution {
    public int lengthOfLastWord(String s) {
        //bymyself
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();

    }
}
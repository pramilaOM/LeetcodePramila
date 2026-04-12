class Solution {
    public int lengthOfLastWord(String s) {

        s = s.trim();
        int n = s.length() - 1;
        int i = 0;
        for (int j = n; j >= 0; j--) {
            if (s.charAt(j) != ' ') {
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
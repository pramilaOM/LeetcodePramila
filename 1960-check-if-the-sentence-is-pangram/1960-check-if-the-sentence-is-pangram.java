class Solution {
    public boolean checkIfPangram(String sentence) {

        boolean[] b = new boolean[26];
        for (char c : sentence.toCharArray()) {
            b[c - 'a'] = true;
        }

        for (boolean bol : b) {
            if (!bol) {
                return false;
            }
        }

        return true;
    }
}
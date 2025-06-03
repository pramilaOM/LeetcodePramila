class Solution {
    public String removeStars(String s) {

        int n = s.length();
        char[] temp = new char[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                j--;
            } else {
                temp[j] = s.charAt(i);
                j++;
            }
        }

        return new String(temp, 0, j);

    }
}
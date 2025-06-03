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

        StringBuilder result = new StringBuilder();
        for (int k = 0; k <= j - 1; k++) {
            result.append(temp[k]);
        }

        return result.toString();

    }
}
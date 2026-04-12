class Solution {
    public String convert(String s, int numRows) {
        String[] str = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            str[i] = "";
        }

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                str[i] += s.charAt(index++);
            }
            for (int i = numRows - 2; i > 0 && index < s.length(); i--) {
                str[i] += s.charAt(index++);
            }

        }
        String ans = "";
        for (String s1 : str) {
            ans += s1;
        }
        return ans;
    }
}
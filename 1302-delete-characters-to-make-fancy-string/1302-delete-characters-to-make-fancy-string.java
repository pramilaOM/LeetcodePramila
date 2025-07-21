class Solution {
    public String makeFancyString(String s) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                count++;
                if (count < 3) {
                    result.append(s.charAt(i));
                }
            } else {
                count = 1;
                result.append(s.charAt(i));
            }

        }
        return result.toString();
    }
}
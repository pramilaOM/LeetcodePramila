class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        int len = strs.length - 1;

        String first = strs[0];
        String last = strs[len];

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }
}
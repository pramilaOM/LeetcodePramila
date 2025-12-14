class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;
        String first = strs[0];
        String last = strs[n - 1];
        StringBuilder ans = new StringBuilder();
        int len = Math.min(last.length(), first.length());
        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            ans.append(last.charAt(i));

        }
        return ans.toString();
    }
}
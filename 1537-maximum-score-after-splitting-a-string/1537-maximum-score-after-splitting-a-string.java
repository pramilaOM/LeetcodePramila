class Solution {
    public int maxScore(String s) {
        int totalOne = 0;
        for (int i : s.toCharArray()) {
            if (i == '1') {
                totalOne++;
            }
        }
        int left = 0;
        int right = totalOne;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {// s.length-1 and not s.length Split the string into two non-empty substrings → So the split point must be before the last character, i.e., i < s.length() - 1
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left+right);
        }
        return max;
    }
}
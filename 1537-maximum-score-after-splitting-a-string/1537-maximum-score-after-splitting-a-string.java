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
        for (int i = 0; i < s.length()-1; i++) {
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
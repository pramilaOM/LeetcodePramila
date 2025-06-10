class Solution {
    public int maxScore(String s) {

        int oneCount = 0;
        int zeroCount = 0;
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            }
            oneCount = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    oneCount++;
                }
            }
            maxDiff = Math.max(maxDiff, zeroCount + oneCount);
        }
    return maxDiff;
    }
}
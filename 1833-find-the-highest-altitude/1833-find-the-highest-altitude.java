class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            if (i - 1 >= 0) {
                preSum[i] = preSum[i - 1] + gain[i - 1];
                max = Math.max(max, preSum[i]);
            } else {
                max = Math.max(max, preSum[i]);
            }

        }
        return max;

    }
}
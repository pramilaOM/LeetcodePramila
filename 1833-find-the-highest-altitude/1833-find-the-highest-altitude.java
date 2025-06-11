class Solution {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int max = 0;
        for (int n : gain) {
            prefixSum += n;
            max = Math.max(prefixSum, max);
        }

        return max;

    }
}
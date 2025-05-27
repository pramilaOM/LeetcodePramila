class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (k == 0) return nums;
        if (n < 2 * k + 1) return ans;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = k; i <= n - k - 1; i++) {
            int leftIndx = i - k;
            int rightIndx = i + k;

            long sum = prefixSum[rightIndx];
            if (leftIndx > 0) {
                sum -= prefixSum[leftIndx - 1];
            }

            ans[i] = (int)(sum / (2 * k + 1));
        }

        return ans;
    }
}

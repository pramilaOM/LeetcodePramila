class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int targetSum = target + prefix[i];

            // Binary search to find the smallest j such that prefix[j] >= targetSum
            int left = i + 1, right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= targetSum) {
                    minLen = Math.min(minLen, mid - i);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
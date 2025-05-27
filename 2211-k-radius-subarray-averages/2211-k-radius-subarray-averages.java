class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    if (k == 0) return nums;
    if (n < 2 * k + 1) return ans;

    long windowSum = 0;
    int windowSize = 2 * k + 1;

    for (int i = 0; i < n; i++) {
        windowSum += nums[i];

        if (i >= windowSize - 1) {
            if (i - k >= 0 && i - k < n)
                ans[i - k] = (int)(windowSum / windowSize);
            windowSum -= nums[i - windowSize + 1];
        }
    }

    return ans;
        
    }
}
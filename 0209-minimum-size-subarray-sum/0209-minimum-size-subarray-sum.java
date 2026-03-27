class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //https://www.youtube.com/watch?v=D2MbogiFXWU

        int i = 0, j = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
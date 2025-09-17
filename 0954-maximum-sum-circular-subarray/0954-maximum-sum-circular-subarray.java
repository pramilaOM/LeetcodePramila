class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int total = 0;

        int currMax = nums[0], maxSum = nums[0];
        int currMin = nums[0], minSum = nums[0];

        total += nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];
            total += x;
            //kadane
            currMax = Math.max(x, currMax + x);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(x, currMin + x);
            minSum = Math.min(minSum, currMin);


        }

        if(maxSum > 0){
            int circular = total - minSum;
            return Math.max(maxSum,circular);
        }
        return maxSum;
    }
}
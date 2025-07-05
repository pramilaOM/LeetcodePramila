class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        double avgSum = Double.NEGATIVE_INFINITY;
        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            
            avgSum = Math.max(avgSum, (double) sum / k);
            sum = 0;
        }
        return avgSum;
    }
}
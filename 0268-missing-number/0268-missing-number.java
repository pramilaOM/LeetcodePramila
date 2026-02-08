class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int remainingsum = 0;
        for (int n1 : nums) {
            remainingsum += n1;
        }

        return totalSum - remainingsum;
    }
}
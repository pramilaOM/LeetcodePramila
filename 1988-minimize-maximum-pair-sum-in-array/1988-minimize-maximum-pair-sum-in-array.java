class Solution {
    public int minPairSum(int[] nums) {

     Arrays.sort(nums);
        int maxPairSum = 0;
        int i = 0, j = nums.length - 1;

        while (i < j) {
            maxPairSum = Math.max(maxPairSum, nums[i] + nums[j]);
            i++;
            j--;
        }

        return maxPairSum; 
    }

}
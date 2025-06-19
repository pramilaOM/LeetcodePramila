class Solution {
    public int partitionArray(int[] nums, int k) {

        int count = 1;
        Arrays.sort(nums);
        int minVal = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] - minVal) > k) {
                count++;
                minVal= nums[i];
            }
        }
        return count;

    }
}
class Solution {
    public int majorityElement(int[] nums) {

        int counter = 0;
        int candidate = -1;

        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
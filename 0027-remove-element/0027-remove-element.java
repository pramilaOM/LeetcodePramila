class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
                continue;
            } else {
                nums[i] = nums[j];
                j++;
                i++;
            }

        }
        return i;
    }
}
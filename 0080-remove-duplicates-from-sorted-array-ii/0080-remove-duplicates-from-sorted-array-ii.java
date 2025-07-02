class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 2;
        for (int read = 2; read < nums.length; read++) {
            if (nums[read] != nums[write - 2]) {
                nums[write] = nums[read];
                write++;
            }

        }

        return write;

    }
}
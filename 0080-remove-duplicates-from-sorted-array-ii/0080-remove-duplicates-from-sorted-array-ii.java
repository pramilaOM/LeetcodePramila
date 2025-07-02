class Solution {
    public int removeDuplicates(int[] nums) {
        //Optimized Approach
        // TC O(n) — one pass to collect elements 
        // O(1) — no extra space used
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
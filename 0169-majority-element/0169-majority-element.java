class Solution {
    public int majorityElement(int[] nums) {
// Optimized Approach — Boyer-Moore Voting Algorithm
        // ⏱ Time Complexity:
        // O(n) — single pass through the array
        // \U0001f9e0 Space Complexity:
        // O(1) — constant space (no extra structures used)
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
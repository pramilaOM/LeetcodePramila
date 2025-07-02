class Solution {
    public void rotate(int[] nums, int k) {
         // Time Complexity:
        // O(n) — you visit each element once

        // \U0001f9e0 Space Complexity:
        // O(n) — due to the extra array used for rotation
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }

        
    }
}
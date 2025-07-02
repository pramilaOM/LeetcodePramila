class Solution {
    public void rotate(int[] nums, int k) {
        // Time Complexity:
        // O(n) — you visit each element once

        // \U0001f9e0 Space Complexity:
        // O(1) — no extra array used for rotation

        int len = nums.length;
        if (k > len) {
            k = k % len;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }

    private static void reverse(int[] nums, int start, int end) {
        // TODO Auto-generated method stub
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
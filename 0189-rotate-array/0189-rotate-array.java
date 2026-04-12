class Solution {
    public void rotate(int[] nums, int k) {

        int[] newNums = new int[nums.length];
        int n = nums.length;
        int idx = 0;
        k = k % n;
        for (int i = n - k; i < n; i++) {
            newNums[idx++] = nums[i];
        }

        for (int i = 0; i < n - k; i++) {
            newNums[idx++] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }

    }
}
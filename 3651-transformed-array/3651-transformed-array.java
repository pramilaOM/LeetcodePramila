class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Create a new array for the results

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i]; // If 0, result is 0
            } else {
                // Calculate the target index with circular array logic
                int steps = nums[i];
                // The formula (i + steps % n + n) % n ensures correct handling of
                // both positive and negative steps, including multiple wrap-arounds.
                int targetIndex = (i + steps % n + n) % n;
                result[i] = nums[targetIndex]; // Set result[i] to the value at targetIndex
            }
        }
        return result;
    }
}
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to process elements in increasing order

        int distinctCount = 0;
        long previousAssignedValue = Long.MIN_VALUE; // Track the last assigned distinct value

        for (int num : nums) {
            // Calculate the minimum possible value for the current element
            // considering both the operation constraint and distinctness
            long minPossibleValue = Math.max((long)num - k, previousAssignedValue + 1);

            // Calculate the maximum possible value for the current element
            long maxPossibleValue = (long)num + k;

            // If we can assign a distinct value to the current element
            if (minPossibleValue <= maxPossibleValue) {
                distinctCount++;
                previousAssignedValue = minPossibleValue; // Update the last assigned value
            }
        }

        return distinctCount;
    }
}
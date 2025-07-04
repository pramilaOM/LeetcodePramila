class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Time O(n) – Two single passes
        // Space O(1) extra (excluding output)
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Build prefix products into answer[]
        // answer[i] = product of all elements to the left of i
        answer[0] = 1; // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Traverse from right to left with a running suffix product
        int suffix = 1; // No elements to the right of index n-1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;

    }
}
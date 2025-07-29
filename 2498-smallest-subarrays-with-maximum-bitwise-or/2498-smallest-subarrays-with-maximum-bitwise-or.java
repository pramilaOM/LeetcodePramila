class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] last = new int[32]; // Last seen index for each bit (0-31)
        Arrays.fill(last, -1);

        for (int i = n - 1; i >= 0; i--) {
            // Update last seen position for each set bit in nums[i]
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    last[b] = i;
                }
            }

            // Find the farthest index we must go to include all set bits
            int farthest = i;
            for (int b = 0; b < 32; b++) {
                if (last[b] != -1) {
                    farthest = Math.max(farthest, last[b]);
                }
            }

            answer[i] = farthest - i + 1;
        }

        return answer;
    }
}
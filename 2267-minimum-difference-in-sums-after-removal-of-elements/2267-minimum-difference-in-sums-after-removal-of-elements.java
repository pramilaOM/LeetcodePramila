class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> L = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        PriorityQueue<Integer> R = new PriorityQueue<>(); // Min-heap

        int N = nums.length / 3;
        long left = 0, right = 0, ans = Long.MAX_VALUE;
        long[] tmp = new long[nums.length];

        // Build tmp[] from the right
        for (int i = nums.length - 1; i >= N; --i) {
            R.add(nums[i]);
            right += nums[i];
            if (R.size() > N) {
                right -= R.poll();
            }
            if (R.size() == N) {
                tmp[i] = right;
            }
        }

        // Traverse from the left
        for (int i = 0; i < nums.length - N; ++i) {
            L.add(nums[i]);
            left += nums[i];
            if (L.size() > N) {
                left -= L.poll();
            }
            if (L.size() == N) {
                ans = Math.min(ans, left - tmp[i + 1]);
            }
        }

        return ans;
    }
}

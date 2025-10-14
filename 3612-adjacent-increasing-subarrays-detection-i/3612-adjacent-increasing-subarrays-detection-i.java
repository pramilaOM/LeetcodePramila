class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int start = 0; start + 2 * k <= n; start++) {
            boolean firstInc = isIncreasing(nums, start, start + k);
            boolean secondInc = isIncreasing(nums, start + k, start + 2 * k);
            if (firstInc && secondInc)
                return true;
        }
        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums.get(i) <= nums.get(i - 1))
                return false;
        }
        return true;
    }
}
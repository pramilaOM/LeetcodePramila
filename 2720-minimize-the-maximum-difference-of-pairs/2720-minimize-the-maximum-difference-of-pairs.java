class Solution {
    int n;

    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int pairs = 0;

        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }
        return pairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {

        this.n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid, p)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;

    }
}
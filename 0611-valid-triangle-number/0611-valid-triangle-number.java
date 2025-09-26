class Solution {
    private int binarySearch(int[] nums, int l, int r, int target) {
        int k = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                k = mid; // mid is valid
                l = mid + 1; // try to go right
            } else {
                r = mid - 1; // go left
            }
        }
        return k;
    }

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;

            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int k = binarySearch(nums, j + 1, n - 1, sum);
                if (k != -1) {
                    count += (k - j);
                }
            }
        }
        return count;
    }
}
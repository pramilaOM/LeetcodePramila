class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivotElement = findPivot(nums, 0, n-1);

        if (nums[pivotElement] == target) {
            return pivotElement;
        }
        int idx = -1;
        idx = binarySearch(0, pivotElement - 1, nums, target);
        if (idx != -1) {
            return idx;
        }
        idx = binarySearch(pivotElement, n - 1, nums, target);

        return idx;
    }

    int findPivot(int[] nums, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    int binarySearch(int l, int r, int[] nums, int target) {
        int idx = -1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return idx;
    }
}
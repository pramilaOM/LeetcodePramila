class Solution {

    public int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int p = nums[l];
        int i = l;
        int j = r;

        while (i <= j) {
            if (nums[i] < p && nums[j] > p) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if (nums[i] >= p) {
                i++;
            }
            if (nums[j] <= p) {
                j--;
            }
        }
        int pivotPos = Math.max(j, l);
        swap(nums, l, pivotPos);
        return pivotPos;
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        //inplace algorithm quick sort
        int n = nums.length;
        int l = 0, r = n - 1;

        int idx = 0;
        while (true) {
            idx = partition(nums, l, r);
            if (idx == k - 1) {
                break;
            } else if (idx > k - 1) {
                r = idx - 1;
            } else {
                l = idx + 1;
            }
        }
        return nums[idx];
    }
}
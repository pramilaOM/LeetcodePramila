class Solution {
    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    int partition(int[] nums, int L, int R) {
        int P = nums[L];
        int i = L + 1;
        int j = R;
        while (i <= j) {
            if (nums[i] < P && nums[j] > P) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if (nums[i] >= P) {
                i++;
            }
            if (nums[j] <= P) {
                j--;
            }

        }
        swap(nums, L, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int L = 0;
        int R = n - 1;
        int pivot_idx = 0;

        while (true) {
            pivot_idx = partition(nums, L, R);
            if (pivot_idx == k - 1) {
                break;
            } else if (pivot_idx > k - 1) {
                R = pivot_idx - 1;
            } else {
                L = pivot_idx + 1;
            }
        }
        return nums[pivot_idx];
    }
}
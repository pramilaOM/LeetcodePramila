class Solution {

    int searchLeft(int[] nums, int target, int n) {
        int l = 0, r = n - 1;
        int left = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                left = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return left;
    }

    int searchRight(int[] nums, int target, int n) {
        int l = 0, r = n - 1;
        int right = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                right = mid;
                l = mid + 1;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
    return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;

        int left = searchLeft(nums, target, n);
        int right = searchRight(nums, target, n);
        return new int[]{left,right};
    }
}
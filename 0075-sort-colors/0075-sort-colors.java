class Solution {
    public void sortColors(int[] nums) {
                int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                mid++;
                start++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        // TODO Auto-generated method stub
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
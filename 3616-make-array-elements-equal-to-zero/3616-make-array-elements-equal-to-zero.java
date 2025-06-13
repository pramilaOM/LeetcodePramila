class Solution {
    public int countValidSelections(int[] nums) {

         int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, i, -1)) {
                    count++;
                }
                if (isValid(nums, i, 1)) {
                    count++;
                }
            }
        }

        return count;
        
    }
    private static boolean isValid(int[] nums, int i, int j) {
        int[] arr = nums.clone();
        int curr = i;
        int dir = j;

        while (curr >= 0 && curr < arr.length) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int val : arr) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        //BF
        // TC O(n) — one pass to collect elements + optional pass to copy back
        // O(n) — extra space used to store filtered elements
        int[] arr = new int[nums.length];
        int count = 1;
        int number = 1;
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                arr[number] = nums[i];
                number++;
            }
        }
        for (int i = 0; i < number; i++) {
            nums[i] = arr[i];
        }
        return number;
    }
}
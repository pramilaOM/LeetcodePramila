class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) {
                nums[i] = n;
                i++;
            }
        }
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }
        return i;
    }
}
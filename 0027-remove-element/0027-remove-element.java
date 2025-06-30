class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val) {
                nums[i] = n;
                i++;
            }
        }
        for (int no : nums) {
            System.out.print(no);
        }
        return i;
    }
}
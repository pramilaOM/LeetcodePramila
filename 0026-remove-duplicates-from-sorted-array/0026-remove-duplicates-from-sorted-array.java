class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int i = 0;
        for (int n : set) {
            nums[i] = n;
            i++;
        }
        return i;
    }
}
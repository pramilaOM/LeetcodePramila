class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> data = new HashSet<>();
        for (int num : nums) {

            if (data.contains(num)) {
                return true;
            }
            data.add(num);

        }
        return false;
    }
}
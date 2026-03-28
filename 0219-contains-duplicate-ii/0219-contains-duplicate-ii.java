class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //https://www.youtube.com/watch?v=AyiGBwFlMb8
        //https://www.youtube.com/watch?v=B5v3KZpRreQ
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {

            if (set.contains(nums[j])) {
                return true;
            }

            set.add(nums[j]);
            if (set.size() > k) {
                set.remove(nums[j - k]);
            }
        }

        return false;
    }
}
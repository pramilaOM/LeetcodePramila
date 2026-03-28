class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //https://www.youtube.com/watch?v=AyiGBwFlMb8
        //https://www.youtube.com/watch?v=B5v3KZpRreQ
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i); // {number, index}
            }
        }

        return false;
    }
}
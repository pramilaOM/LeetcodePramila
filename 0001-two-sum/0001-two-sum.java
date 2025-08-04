class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];
            if (mp.containsKey(remaining)) {
                return new int[] { mp.get(remaining), i };
            }
            mp.put(nums[i], i);
        }
        return new int[] {};
    }
}
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> result = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(nums.length - 1, j + k);

                for (int i = start; i <= end; i++) {
                    result.add(i);
                }
            }
        }
        List<Integer> r = new ArrayList<>(result);
        Collections.sort(r);
        return r;

    }
}
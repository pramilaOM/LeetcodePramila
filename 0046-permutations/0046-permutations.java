class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> temp = new ArrayList<>();
        backtrack(temp, nums);
        return result;

    }

    void backtrack(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {

            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used.contains(nums[i])) {
                temp.add(nums[i]);
                used.add(nums[i]);

                backtrack(temp, nums);

                used.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
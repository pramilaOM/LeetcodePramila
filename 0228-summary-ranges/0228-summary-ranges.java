class Solution {
    public List<String> summaryRanges(int[] nums) {
        //did by myself
        //Time Complexity: O(n), because each element is visited once.

        // Space Complexity: O(1) extra (excluding result list).

        int n = nums.length;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            int end = nums[i];
            if (start == end) {
                ans.add(String.valueOf(start));
            } else {
                ans.add(start + "->" + end);
            }

        }
        return ans;
    }
}
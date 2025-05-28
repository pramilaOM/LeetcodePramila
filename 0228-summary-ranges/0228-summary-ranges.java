class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = nums[i];
            while (i + 1 < n && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            int end = nums[i];
            if (start != end) {
                result.add(start + "->" + end);
            } else {
                result.add(String.valueOf(start));
            }
            i++;
        }
        return result;

    }
}
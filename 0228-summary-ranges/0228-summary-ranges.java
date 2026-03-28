class Solution {
    public List<String> summaryRanges(int[] nums) {
        //https://www.youtube.com/watch?v=PyYZCJRAMmY
        int n = nums.length;
        List<String> result = new ArrayList<>();

        if (n == 0)
            return result;

        for (int i = 0; i < n; i++) {

            int start = nums[i];

            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }

        return result;
    }
}
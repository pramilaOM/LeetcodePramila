class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prePrev = 0;
        int prev = nums[0];

        for (int i = 2; i <= n; i++) {
            int skip = prev;
            int take = nums[i - 1] + prePrev;
            int temp = Math.max(skip, take);

            prePrev = prev;
            prev = temp;
        }

        return prev;
    }
}
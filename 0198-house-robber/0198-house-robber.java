class Solution {
    public int rob(int[] nums) {
        //Bottom Up it will not work if = is missed in for loop
        int n = nums.length;
        int t[] = new int[n + 1];
        Arrays.fill(t, 0);
        t[0] = 0;
        t[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            int steal = nums[i - 1] + t[i - 2];
            int skip = t[i - 1];

            t[i] = Math.max(steal, skip);
        }

        return t[n];
    }
}
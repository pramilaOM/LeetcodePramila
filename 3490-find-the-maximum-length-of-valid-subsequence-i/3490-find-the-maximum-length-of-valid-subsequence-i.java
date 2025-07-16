class Solution {
    public int maximumLength(int[] nums) {

        int countOdd = 0;
        int coutEven = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                coutEven++;
            } else {
                countOdd++;
            }
        }
        int altLen = 1, prevParity = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int currParity = nums[i] % 2;
            if (currParity != prevParity) {
                altLen++;
                prevParity = currParity;
            }
        }
        return Math.max(Math.max(countOdd, coutEven), altLen);
    }
}
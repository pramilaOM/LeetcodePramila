class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int k = 0; k <= 31; k++) {
            int temp = (1 << k);
            int countOne = 0;
            for (int num : nums) {
                if ((num & temp) != 0) {
                    countOne++;
                }
            }
            if (countOne % 3 == 1) {
                result = (result | temp);
            }
        }

        return result;
    }
}
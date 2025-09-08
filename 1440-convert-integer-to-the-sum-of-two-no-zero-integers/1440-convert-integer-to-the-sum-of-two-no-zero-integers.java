class Solution {
    boolean check(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {

        for (int i = 1; i <= n; i++) {
            int j = n - i;
            if (check(i) && check(j)) {
                return new int[] { i, j };
            }
        }
        return new int[] {};
    }
}
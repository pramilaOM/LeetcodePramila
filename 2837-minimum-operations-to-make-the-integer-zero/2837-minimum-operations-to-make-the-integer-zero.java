class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1; k <= 60; k++) {
            long target = num1 - k * num2;
            if (target < k) {
                break;
            }
            long setBits = Long.bitCount(target);
            
            if (setBits <= k) {
                return (int) k;
            }
        }
        return -1;
    }
}
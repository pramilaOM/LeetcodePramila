class Solution {
    private int getCountNumber(int n) {
        int num = 0;
        while (n > 0) {
            num += Math.pow(10, n % 10);
            n /= 10;
        }
        return num;
    }

    public boolean reorderedPowerOf2(int n) {
        int inputCount = getCountNumber(n);

        for (int p = 0; p <= 29; p++) {
            if (inputCount == getCountNumber(1 << p)) {
                return true;
            }
        }

        return false;
    }
}
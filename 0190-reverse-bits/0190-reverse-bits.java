class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; //left shift
            if ((n & 1) == 1) {//check last bit
                result++;
            }
            n >>= 1;// right shift
        }
        return result;
    }
}
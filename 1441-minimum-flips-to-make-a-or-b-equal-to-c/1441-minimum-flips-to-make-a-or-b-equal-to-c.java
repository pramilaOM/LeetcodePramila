class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int abit = (a >> i) & 1;
            int bbit = (b >> i) & 1;
            int cbit = (c >> i) & 1;

            int or = abit | bbit;

            if (or == cbit) {
                continue;
            }
            if (cbit == 0) {
                flips += abit + bbit;
            } else {
                flips += 1;
            }

        }
        return flips;
    }
}
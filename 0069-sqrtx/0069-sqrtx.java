class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x / 2 + 1;  

        while (l <= r) {
            int m = l + (r - l) / 2;
            long square = (long) m * m;

            if (square == x) return m;
            else if (square < x) l = m + 1;
            else r = m - 1;
        }

        return r;
    }
}
